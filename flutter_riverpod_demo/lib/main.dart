import 'dart:async';

import 'package:flutter/material.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';
import 'package:flutter_hooks/flutter_hooks.dart';
import 'package:state_notifier/state_notifier.dart';

// We create a "provider", which will store a value (here "Hello world").
// By using a provider, this allows us to mock/override the value exposed.
final helloWorldProvider = Provider((_) => 'Hello world');
// final greetingProvider = Provider((_) => 'Greeting');
// final myProvider = Provider((_) => {"key": "value"});
// final myAutoDisposeProvider = StateProvider.autoDispose<String>((ref) => 0);
// final myFamilyProvider = Provider.family<String, int>((ref, id) => '$id');
// final userProvider =
//     FutureProvider.autoDispose.family<User, int>((ref, userId) async {
//   return fetchUser(userId);
// });

final example = StreamProvider.autoDispose((ProviderReference ref) {
  final StreamController streamController = StreamController<int>();

  ref.onDispose(() {
    // Closes the streamController when the state of this provider is destroyed.
    streamController.close();
  });
  return streamController.stream;
});

void main() {
  runApp(
    // For widgets to be able to read providers, we need to wrap the entire
    // application in a "ProviderScope" widget.
    // This is where the state of our providers will be stored.
    ProviderScope(
      child: MyApp(),
      // child: TestWidget(),
    ),
  );
}

class TestWidget extends StatefulHookWidget {
  TestWidget({Key key}) : super(key: key);
  @override
  _TestWidgetState createState() => _TestWidgetState();
}

class _TestWidgetState extends State<TestWidget> {
  final Counter counter = useProvider(counterProvider);
  @override
  Widget build(BuildContext context) {
    return Text('${counter.state}');
  }
}

// Note: MyApp is a HookWidget, from flutter_hooks.
class MyApp extends HookWidget {
  @override
  Widget build(BuildContext context) {
    // To read our provider, we can use the hook "useProvider".
    // This is only possible because MyApp is a HookWidget.
    final String value = useProvider(helloWorldProvider);
    final Counter counter = useProvider(counterProvider);
    bool isAbove5 = useProvider(counterProvider.select((c) => c.state > 5));

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Example')),
        body: Column(
          children: [
            Text(value),
            Divider(),
            // Text('${counter.state}'),
            Divider(),
            TestWidget(),
            Divider(),
            Text('Is counter > 5 ? $isAbove5'),
          ],
        ),
        floatingActionButton: FloatingActionButton(
          // onPressed: () => context.read(counterProvider).incremnet(),
          onPressed: counter.incremnet,
          child: Icon(Icons.add),
        ),
      ),
    );
  }
}

class Counter extends StateNotifier<int> {
  Counter() : super(0);

  void incremnet() => state++;
}

final counterProvider = StateNotifierProvider<Counter>((ref) => Counter());
