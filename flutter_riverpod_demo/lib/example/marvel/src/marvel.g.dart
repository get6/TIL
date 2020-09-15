// GENERATED CODE - DO NOT MODIFY BY HAND

part of marvel;

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_Character _$_$_CharacterFromJson(Map<String, dynamic> json) {
  return _$_Character(
    id: json['id'] as int,
    name: json['name'] as String,
    thumbnail: json['thumbnail'] == null
        ? null
        : Thumbnail.fromJson(json['thumbnail'] as Map<String, dynamic>),
  );
}

Map<String, dynamic> _$_$_CharacterToJson(_$_Character instance) =>
    <String, dynamic>{
      'id': instance.id,
      'name': instance.name,
      'thumbnail': instance.thumbnail,
    };

_$_Thumbnatil _$_$_ThumbnatilFromJson(Map<String, dynamic> json) {
  return _$_Thumbnatil(
    path: json['path'] as String,
    extension: json['extension'] as String,
  );
}

Map<String, dynamic> _$_$_ThumbnatilToJson(_$_Thumbnatil instance) =>
    <String, dynamic>{
      'path': instance.path,
      'extension': instance.extension,
    };

_$_MarvelResponse _$_$_MarvelResponseFromJson(Map<String, dynamic> json) {
  return _$_MarvelResponse(
    json['data'] == null
        ? null
        : MarvelData.fromJson(json['data'] as Map<String, dynamic>),
  );
}

Map<String, dynamic> _$_$_MarvelResponseToJson(_$_MarvelResponse instance) =>
    <String, dynamic>{
      'data': instance.data,
    };

_$_MarvelData _$_$_MarvelDataFromJson(Map<String, dynamic> json) {
  return _$_MarvelData(
    (json['results'] as List)?.map((e) => e as Map<String, dynamic>)?.toList(),
    json['total'] as int,
  );
}

Map<String, dynamic> _$_$_MarvelDataToJson(_$_MarvelData instance) =>
    <String, dynamic>{
      'results': instance.results,
      'total': instance.total,
    };
