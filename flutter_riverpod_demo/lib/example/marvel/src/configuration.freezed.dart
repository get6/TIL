// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies

part of 'configuration.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;
Configuration _$ConfigurationFromJson(Map<String, dynamic> json) {
  return _Configuration.fromJson(json);
}

class _$ConfigurationTearOff {
  const _$ConfigurationTearOff();

// ignore: unused_element
  _Configuration call(
      {@required String publicKey, @required String privateKey}) {
    return _Configuration(
      publicKey: publicKey,
      privateKey: privateKey,
    );
  }
}

// ignore: unused_element
const $Configuration = _$ConfigurationTearOff();

mixin _$Configuration {
  String get publicKey;
  String get privateKey;

  Map<String, dynamic> toJson();
  $ConfigurationCopyWith<Configuration> get copyWith;
}

abstract class $ConfigurationCopyWith<$Res> {
  factory $ConfigurationCopyWith(
          Configuration value, $Res Function(Configuration) then) =
      _$ConfigurationCopyWithImpl<$Res>;
  $Res call({String publicKey, String privateKey});
}

class _$ConfigurationCopyWithImpl<$Res>
    implements $ConfigurationCopyWith<$Res> {
  _$ConfigurationCopyWithImpl(this._value, this._then);

  final Configuration _value;
  // ignore: unused_field
  final $Res Function(Configuration) _then;

  @override
  $Res call({
    Object publicKey = freezed,
    Object privateKey = freezed,
  }) {
    return _then(_value.copyWith(
      publicKey: publicKey == freezed ? _value.publicKey : publicKey as String,
      privateKey:
          privateKey == freezed ? _value.privateKey : privateKey as String,
    ));
  }
}

abstract class _$ConfigurationCopyWith<$Res>
    implements $ConfigurationCopyWith<$Res> {
  factory _$ConfigurationCopyWith(
          _Configuration value, $Res Function(_Configuration) then) =
      __$ConfigurationCopyWithImpl<$Res>;
  @override
  $Res call({String publicKey, String privateKey});
}

class __$ConfigurationCopyWithImpl<$Res>
    extends _$ConfigurationCopyWithImpl<$Res>
    implements _$ConfigurationCopyWith<$Res> {
  __$ConfigurationCopyWithImpl(
      _Configuration _value, $Res Function(_Configuration) _then)
      : super(_value, (v) => _then(v as _Configuration));

  @override
  _Configuration get _value => super._value as _Configuration;

  @override
  $Res call({
    Object publicKey = freezed,
    Object privateKey = freezed,
  }) {
    return _then(_Configuration(
      publicKey: publicKey == freezed ? _value.publicKey : publicKey as String,
      privateKey:
          privateKey == freezed ? _value.privateKey : privateKey as String,
    ));
  }
}

@JsonSerializable(fieldRename: FieldRename.snake)
class _$_Configuration with DiagnosticableTreeMixin implements _Configuration {
  _$_Configuration({@required this.publicKey, @required this.privateKey})
      : assert(publicKey != null),
        assert(privateKey != null);

  factory _$_Configuration.fromJson(Map<String, dynamic> json) =>
      _$_$_ConfigurationFromJson(json);

  @override
  final String publicKey;
  @override
  final String privateKey;

  @override
  String toString({DiagnosticLevel minLevel = DiagnosticLevel.info}) {
    return 'Configuration(publicKey: $publicKey, privateKey: $privateKey)';
  }

  @override
  void debugFillProperties(DiagnosticPropertiesBuilder properties) {
    super.debugFillProperties(properties);
    properties
      ..add(DiagnosticsProperty('type', 'Configuration'))
      ..add(DiagnosticsProperty('publicKey', publicKey))
      ..add(DiagnosticsProperty('privateKey', privateKey));
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _Configuration &&
            (identical(other.publicKey, publicKey) ||
                const DeepCollectionEquality()
                    .equals(other.publicKey, publicKey)) &&
            (identical(other.privateKey, privateKey) ||
                const DeepCollectionEquality()
                    .equals(other.privateKey, privateKey)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^
      const DeepCollectionEquality().hash(publicKey) ^
      const DeepCollectionEquality().hash(privateKey);

  @override
  _$ConfigurationCopyWith<_Configuration> get copyWith =>
      __$ConfigurationCopyWithImpl<_Configuration>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$_$_ConfigurationToJson(this);
  }
}

abstract class _Configuration implements Configuration {
  factory _Configuration(
      {@required String publicKey,
      @required String privateKey}) = _$_Configuration;

  factory _Configuration.fromJson(Map<String, dynamic> json) =
      _$_Configuration.fromJson;

  @override
  String get publicKey;
  @override
  String get privateKey;
  @override
  _$ConfigurationCopyWith<_Configuration> get copyWith;
}
