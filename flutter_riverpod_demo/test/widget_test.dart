// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility that Flutter provides. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';

class Repository {
  Future<List<Todo>> fetchTodos() async {}
}

class Todo {
  Todo({this.id, this.label, this.completed});

  final String id;
  final String label;
  final bool completed;
}

// We expose our instance of Repository in a provider
final repositoryProvider = Provider((ref) => Repository());

/// The list of todos. Here, we are simply fetching them from the server using
/// [Repository] and doing nothing else.
final todoListProvider = FutureProvider((ref) async {
  // Obtains the Repository instance
  final repository = ref.read(repositoryProvider);

  // Fetch the todos and expose them to the UI.
  return repository.fetchTodos();
});

/// A mocked implementation of Repository that returns a pre-defined list of todos
class FakeRepository implements Repository {
  @override
  Future<List<Todo>> fetchTodos() async {
    return <Todo>[
      Todo(id: '42', label: 'Hello world', completed: false),
    ];
  }
}

class TodoItem extends StatelessWidget {
  const TodoItem({Key key, this.todo}) : super(key: key);
  final Todo todo;

  @override
  Widget build(BuildContext context) {
    return Text(todo.label);
  }
}

// A Counter implemented and tested using Flutter

// We declared a provider globally, and we will use i in two tests, to see
// if ther state correctly resets to '0' between tests.
final counterProvider = StateProvider((ref) => 0);

// Renders the current state and a button that allows incrementing the state
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Consumer(
        builder: (context, watch, _) {
          final counter = watch(counterProvider);
          return RaisedButton(
            onPressed: () => counter.state++,
            child: Text('${counter.state}'),
          );
        },
      ),
    );
  }
}

void main() {
  testWidgets('update the UI when incrementing the state',
      (WidgetTester tester) async {
    await tester.pumpWidget(
      ProviderScope(
        child: MyApp(),
      ),
    );

    // The default value is `0`, as declared in our provider
    expect(find.text('0'), findsOneWidget);
    expect(find.text('1'), findsNothing);

    // Increment the state and re-render
    await tester.tap(find.byType(RaisedButton));
    await tester.pump();

    // The state have properly incremented
    expect(find.text('1'), findsOneWidget);
    expect(find.text('0'), findsNothing);
  });

  testWidgets(
    'the counter state is not shared between tests',
    (WidgetTester tester) async {
      await tester.pumpWidget(
        ProviderScope(
          child: MyApp(),
        ),
      );

      // The state is `0` once again, with no tearDown/setUp needed
      expect(find.text('0'), findsOneWidget);
      expect(find.text('1'), findsNothing);
    },
  );

  testWidgets('override repositoryProvider', (WidgetTester tester) async {
    await tester.pumpWidget(
      ProviderScope(
        overrides: [
          repositoryProvider
              .overrideWithProvider(Provider((ref) => FakeRepository())),
        ],
        // Our application, which will read from todoListProvider to display the todo-list.
        // You may extract this int a MyApp widget
        child: MaterialApp(
          home: Scaffold(
            body: Consumer(
              builder: (context, watch, _) {
                final todos = watch(todoListProvider);
                // The list of todos is loading or in error
                if (todos.data == null) {
                  return const CircularProgressIndicator();
                }
                return ListView(
                  children: [
                    for (final todo in todos.data.value)
                      TodoItem(
                        todo: todo,
                      )
                  ],
                );
              },
            ),
          ),
        ),
      ),
    );

    // The first frame is a loading state.
    expect(find.byType(CircularProgressIndicator), findsOneWidget);

    // Re-render. TodoListProvider should have finished fetching the todos by now
    await tester.pump();

    // No-longer loading
    expect(find.byType(CircularProgressIndicator), findsNothing);

    // Rendered one TodoItem with the data returned by FakeRepository
    expect(tester.widgetList(find.byType(TodoItem)), [
      isA<TodoItem>()
          .having((s) => s.todo.id, 'todo.id', '42')
          .having((s) => s.todo.label, 'todo.label', 'Hello world')
          .having((s) => s.todo.completed, 'todo.completed', false)
    ]);
  });
}
