// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies

part of 'result.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

class _$ResultTearOff {
  const _$ResultTearOff();

// ignore: unused_element
  _ResultData<T> data<T>(T value) {
    return _ResultData<T>(
      value,
    );
  }

// ignore: unused_element
  _ResultError<T> error<T>(Object error, [StackTrace stackTrace]) {
    return _ResultError<T>(
      error,
      stackTrace,
    );
  }
}

// ignore: unused_element
const $Result = _$ResultTearOff();

mixin _$Result<T> {
  @optionalTypeArgs
  Result when<Result extends Object>({
    @required Result data(T value),
    @required Result error(Object error, StackTrace stackTrace),
  });
  @optionalTypeArgs
  Result maybeWhen<Result extends Object>({
    Result data(T value),
    Result error(Object error, StackTrace stackTrace),
    @required Result orElse(),
  });
  @optionalTypeArgs
  Result map<Result extends Object>({
    @required Result data(_ResultData<T> value),
    @required Result error(_ResultError<T> value),
  });
  @optionalTypeArgs
  Result maybeMap<Result extends Object>({
    Result data(_ResultData<T> value),
    Result error(_ResultError<T> value),
    @required Result orElse(),
  });
}

abstract class $ResultCopyWith<T, $Res> {
  factory $ResultCopyWith(Result<T> value, $Res Function(Result<T>) then) =
      _$ResultCopyWithImpl<T, $Res>;
}

class _$ResultCopyWithImpl<T, $Res> implements $ResultCopyWith<T, $Res> {
  _$ResultCopyWithImpl(this._value, this._then);

  final Result<T> _value;
  // ignore: unused_field
  final $Res Function(Result<T>) _then;
}

abstract class _$ResultDataCopyWith<T, $Res> {
  factory _$ResultDataCopyWith(
          _ResultData<T> value, $Res Function(_ResultData<T>) then) =
      __$ResultDataCopyWithImpl<T, $Res>;
  $Res call({T value});
}

class __$ResultDataCopyWithImpl<T, $Res> extends _$ResultCopyWithImpl<T, $Res>
    implements _$ResultDataCopyWith<T, $Res> {
  __$ResultDataCopyWithImpl(
      _ResultData<T> _value, $Res Function(_ResultData<T>) _then)
      : super(_value, (v) => _then(v as _ResultData<T>));

  @override
  _ResultData<T> get _value => super._value as _ResultData<T>;

  @override
  $Res call({
    Object value = freezed,
  }) {
    return _then(_ResultData<T>(
      value == freezed ? _value.value : value as T,
    ));
  }
}

class _$_ResultData<T> extends _ResultData<T> {
  _$_ResultData(this.value)
      : assert(value != null),
        super._();

  @override
  final T value;

  @override
  String toString() {
    return 'Result<$T>.data(value: $value)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _ResultData<T> &&
            (identical(other.value, value) ||
                const DeepCollectionEquality().equals(other.value, value)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^ const DeepCollectionEquality().hash(value);

  @override
  _$ResultDataCopyWith<T, _ResultData<T>> get copyWith =>
      __$ResultDataCopyWithImpl<T, _ResultData<T>>(this, _$identity);

  @override
  @optionalTypeArgs
  Result when<Result extends Object>({
    @required Result data(T value),
    @required Result error(Object error, StackTrace stackTrace),
  }) {
    assert(data != null);
    assert(error != null);
    return data(value);
  }

  @override
  @optionalTypeArgs
  Result maybeWhen<Result extends Object>({
    Result data(T value),
    Result error(Object error, StackTrace stackTrace),
    @required Result orElse(),
  }) {
    assert(orElse != null);
    if (data != null) {
      return data(value);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  Result map<Result extends Object>({
    @required Result data(_ResultData<T> value),
    @required Result error(_ResultError<T> value),
  }) {
    assert(data != null);
    assert(error != null);
    return data(this);
  }

  @override
  @optionalTypeArgs
  Result maybeMap<Result extends Object>({
    Result data(_ResultData<T> value),
    Result error(_ResultError<T> value),
    @required Result orElse(),
  }) {
    assert(orElse != null);
    if (data != null) {
      return data(this);
    }
    return orElse();
  }
}

abstract class _ResultData<T> extends Result<T> {
  _ResultData._() : super._();
  factory _ResultData(T value) = _$_ResultData<T>;

  T get value;
  _$ResultDataCopyWith<T, _ResultData<T>> get copyWith;
}

abstract class _$ResultErrorCopyWith<T, $Res> {
  factory _$ResultErrorCopyWith(
          _ResultError<T> value, $Res Function(_ResultError<T>) then) =
      __$ResultErrorCopyWithImpl<T, $Res>;
  $Res call({Object error, StackTrace stackTrace});
}

class __$ResultErrorCopyWithImpl<T, $Res> extends _$ResultCopyWithImpl<T, $Res>
    implements _$ResultErrorCopyWith<T, $Res> {
  __$ResultErrorCopyWithImpl(
      _ResultError<T> _value, $Res Function(_ResultError<T>) _then)
      : super(_value, (v) => _then(v as _ResultError<T>));

  @override
  _ResultError<T> get _value => super._value as _ResultError<T>;

  @override
  $Res call({
    Object error = freezed,
    Object stackTrace = freezed,
  }) {
    return _then(_ResultError<T>(
      error == freezed ? _value.error : error,
      stackTrace == freezed ? _value.stackTrace : stackTrace as StackTrace,
    ));
  }
}

class _$_ResultError<T> extends _ResultError<T> {
  _$_ResultError(this.error, [this.stackTrace])
      : assert(error != null),
        super._();

  @override
  final Object error;
  @override
  final StackTrace stackTrace;

  @override
  String toString() {
    return 'Result<$T>.error(error: $error, stackTrace: $stackTrace)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _ResultError<T> &&
            (identical(other.error, error) ||
                const DeepCollectionEquality().equals(other.error, error)) &&
            (identical(other.stackTrace, stackTrace) ||
                const DeepCollectionEquality()
                    .equals(other.stackTrace, stackTrace)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^
      const DeepCollectionEquality().hash(error) ^
      const DeepCollectionEquality().hash(stackTrace);

  @override
  _$ResultErrorCopyWith<T, _ResultError<T>> get copyWith =>
      __$ResultErrorCopyWithImpl<T, _ResultError<T>>(this, _$identity);

  @override
  @optionalTypeArgs
  Result when<Result extends Object>({
    @required Result data(T value),
    @required Result error(Object error, StackTrace stackTrace),
  }) {
    assert(data != null);
    assert(error != null);
    return error(this.error, stackTrace);
  }

  @override
  @optionalTypeArgs
  Result maybeWhen<Result extends Object>({
    Result data(T value),
    Result error(Object error, StackTrace stackTrace),
    @required Result orElse(),
  }) {
    assert(orElse != null);
    if (error != null) {
      return error(this.error, stackTrace);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  Result map<Result extends Object>({
    @required Result data(_ResultData<T> value),
    @required Result error(_ResultError<T> value),
  }) {
    assert(data != null);
    assert(error != null);
    return error(this);
  }

  @override
  @optionalTypeArgs
  Result maybeMap<Result extends Object>({
    Result data(_ResultData<T> value),
    Result error(_ResultError<T> value),
    @required Result orElse(),
  }) {
    assert(orElse != null);
    if (error != null) {
      return error(this);
    }
    return orElse();
  }
}

abstract class _ResultError<T> extends Result<T> {
  _ResultError._() : super._();
  factory _ResultError(Object error, [StackTrace stackTrace]) =
      _$_ResultError<T>;

  Object get error;
  StackTrace get stackTrace;
  _$ResultErrorCopyWith<T, _ResultError<T>> get copyWith;
}
