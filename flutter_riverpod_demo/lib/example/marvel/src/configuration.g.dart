// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'configuration.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_Configuration _$_$_ConfigurationFromJson(Map<String, dynamic> json) {
  return _$_Configuration(
    publicKey: json['public_key'] as String,
    privateKey: json['private_key'] as String,
  );
}

Map<String, dynamic> _$_$_ConfigurationToJson(_$_Configuration instance) =>
    <String, dynamic>{
      'public_key': instance.publicKey,
      'private_key': instance.privateKey,
    };
