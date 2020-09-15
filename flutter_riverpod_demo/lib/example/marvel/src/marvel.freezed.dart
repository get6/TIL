// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies

part of marvel;

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

class _$MarvelListCharactersResponseTearOff {
  const _$MarvelListCharactersResponseTearOff();

// ignore: unused_element
  _MarvelListCharactersResponse call(
      {@required int totalCount, @required List<Character> characters}) {
    return _MarvelListCharactersResponse(
      totalCount: totalCount,
      characters: characters,
    );
  }
}

// ignore: unused_element
const $MarvelListCharactersResponse = _$MarvelListCharactersResponseTearOff();

mixin _$MarvelListCharactersResponse {
  int get totalCount;
  List<Character> get characters;

  $MarvelListCharactersResponseCopyWith<MarvelListCharactersResponse>
      get copyWith;
}

abstract class $MarvelListCharactersResponseCopyWith<$Res> {
  factory $MarvelListCharactersResponseCopyWith(
          MarvelListCharactersResponse value,
          $Res Function(MarvelListCharactersResponse) then) =
      _$MarvelListCharactersResponseCopyWithImpl<$Res>;
  $Res call({int totalCount, List<Character> characters});
}

class _$MarvelListCharactersResponseCopyWithImpl<$Res>
    implements $MarvelListCharactersResponseCopyWith<$Res> {
  _$MarvelListCharactersResponseCopyWithImpl(this._value, this._then);

  final MarvelListCharactersResponse _value;
  // ignore: unused_field
  final $Res Function(MarvelListCharactersResponse) _then;

  @override
  $Res call({
    Object totalCount = freezed,
    Object characters = freezed,
  }) {
    return _then(_value.copyWith(
      totalCount: totalCount == freezed ? _value.totalCount : totalCount as int,
      characters: characters == freezed
          ? _value.characters
          : characters as List<Character>,
    ));
  }
}

abstract class _$MarvelListCharactersResponseCopyWith<$Res>
    implements $MarvelListCharactersResponseCopyWith<$Res> {
  factory _$MarvelListCharactersResponseCopyWith(
          _MarvelListCharactersResponse value,
          $Res Function(_MarvelListCharactersResponse) then) =
      __$MarvelListCharactersResponseCopyWithImpl<$Res>;
  @override
  $Res call({int totalCount, List<Character> characters});
}

class __$MarvelListCharactersResponseCopyWithImpl<$Res>
    extends _$MarvelListCharactersResponseCopyWithImpl<$Res>
    implements _$MarvelListCharactersResponseCopyWith<$Res> {
  __$MarvelListCharactersResponseCopyWithImpl(
      _MarvelListCharactersResponse _value,
      $Res Function(_MarvelListCharactersResponse) _then)
      : super(_value, (v) => _then(v as _MarvelListCharactersResponse));

  @override
  _MarvelListCharactersResponse get _value =>
      super._value as _MarvelListCharactersResponse;

  @override
  $Res call({
    Object totalCount = freezed,
    Object characters = freezed,
  }) {
    return _then(_MarvelListCharactersResponse(
      totalCount: totalCount == freezed ? _value.totalCount : totalCount as int,
      characters: characters == freezed
          ? _value.characters
          : characters as List<Character>,
    ));
  }
}

class _$_MarvelListCharactersResponse implements _MarvelListCharactersResponse {
  _$_MarvelListCharactersResponse(
      {@required this.totalCount, @required this.characters})
      : assert(totalCount != null),
        assert(characters != null);

  @override
  final int totalCount;
  @override
  final List<Character> characters;

  @override
  String toString() {
    return 'MarvelListCharactersResponse(totalCount: $totalCount, characters: $characters)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _MarvelListCharactersResponse &&
            (identical(other.totalCount, totalCount) ||
                const DeepCollectionEquality()
                    .equals(other.totalCount, totalCount)) &&
            (identical(other.characters, characters) ||
                const DeepCollectionEquality()
                    .equals(other.characters, characters)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^
      const DeepCollectionEquality().hash(totalCount) ^
      const DeepCollectionEquality().hash(characters);

  @override
  _$MarvelListCharactersResponseCopyWith<_MarvelListCharactersResponse>
      get copyWith => __$MarvelListCharactersResponseCopyWithImpl<
          _MarvelListCharactersResponse>(this, _$identity);
}

abstract class _MarvelListCharactersResponse
    implements MarvelListCharactersResponse {
  factory _MarvelListCharactersResponse(
      {@required int totalCount,
      @required List<Character> characters}) = _$_MarvelListCharactersResponse;

  @override
  int get totalCount;
  @override
  List<Character> get characters;
  @override
  _$MarvelListCharactersResponseCopyWith<_MarvelListCharactersResponse>
      get copyWith;
}

Character _$CharacterFromJson(Map<String, dynamic> json) {
  return _Character.fromJson(json);
}

class _$CharacterTearOff {
  const _$CharacterTearOff();

// ignore: unused_element
  _Character call(
      {@required int id,
      @required String name,
      @required Thumbnail thumbnail}) {
    return _Character(
      id: id,
      name: name,
      thumbnail: thumbnail,
    );
  }
}

// ignore: unused_element
const $Character = _$CharacterTearOff();

mixin _$Character {
  int get id;
  String get name;
  Thumbnail get thumbnail;

  Map<String, dynamic> toJson();
  $CharacterCopyWith<Character> get copyWith;
}

abstract class $CharacterCopyWith<$Res> {
  factory $CharacterCopyWith(Character value, $Res Function(Character) then) =
      _$CharacterCopyWithImpl<$Res>;
  $Res call({int id, String name, Thumbnail thumbnail});

  $ThumbnailCopyWith<$Res> get thumbnail;
}

class _$CharacterCopyWithImpl<$Res> implements $CharacterCopyWith<$Res> {
  _$CharacterCopyWithImpl(this._value, this._then);

  final Character _value;
  // ignore: unused_field
  final $Res Function(Character) _then;

  @override
  $Res call({
    Object id = freezed,
    Object name = freezed,
    Object thumbnail = freezed,
  }) {
    return _then(_value.copyWith(
      id: id == freezed ? _value.id : id as int,
      name: name == freezed ? _value.name : name as String,
      thumbnail:
          thumbnail == freezed ? _value.thumbnail : thumbnail as Thumbnail,
    ));
  }

  @override
  $ThumbnailCopyWith<$Res> get thumbnail {
    if (_value.thumbnail == null) {
      return null;
    }
    return $ThumbnailCopyWith<$Res>(_value.thumbnail, (value) {
      return _then(_value.copyWith(thumbnail: value));
    });
  }
}

abstract class _$CharacterCopyWith<$Res> implements $CharacterCopyWith<$Res> {
  factory _$CharacterCopyWith(
          _Character value, $Res Function(_Character) then) =
      __$CharacterCopyWithImpl<$Res>;
  @override
  $Res call({int id, String name, Thumbnail thumbnail});

  @override
  $ThumbnailCopyWith<$Res> get thumbnail;
}

class __$CharacterCopyWithImpl<$Res> extends _$CharacterCopyWithImpl<$Res>
    implements _$CharacterCopyWith<$Res> {
  __$CharacterCopyWithImpl(_Character _value, $Res Function(_Character) _then)
      : super(_value, (v) => _then(v as _Character));

  @override
  _Character get _value => super._value as _Character;

  @override
  $Res call({
    Object id = freezed,
    Object name = freezed,
    Object thumbnail = freezed,
  }) {
    return _then(_Character(
      id: id == freezed ? _value.id : id as int,
      name: name == freezed ? _value.name : name as String,
      thumbnail:
          thumbnail == freezed ? _value.thumbnail : thumbnail as Thumbnail,
    ));
  }
}

@JsonSerializable()
class _$_Character implements _Character {
  _$_Character(
      {@required this.id, @required this.name, @required this.thumbnail})
      : assert(id != null),
        assert(name != null),
        assert(thumbnail != null);

  factory _$_Character.fromJson(Map<String, dynamic> json) =>
      _$_$_CharacterFromJson(json);

  @override
  final int id;
  @override
  final String name;
  @override
  final Thumbnail thumbnail;

  @override
  String toString() {
    return 'Character(id: $id, name: $name, thumbnail: $thumbnail)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _Character &&
            (identical(other.id, id) ||
                const DeepCollectionEquality().equals(other.id, id)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.thumbnail, thumbnail) ||
                const DeepCollectionEquality()
                    .equals(other.thumbnail, thumbnail)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^
      const DeepCollectionEquality().hash(id) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(thumbnail);

  @override
  _$CharacterCopyWith<_Character> get copyWith =>
      __$CharacterCopyWithImpl<_Character>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$_$_CharacterToJson(this);
  }
}

abstract class _Character implements Character {
  factory _Character(
      {@required int id,
      @required String name,
      @required Thumbnail thumbnail}) = _$_Character;

  factory _Character.fromJson(Map<String, dynamic> json) =
      _$_Character.fromJson;

  @override
  int get id;
  @override
  String get name;
  @override
  Thumbnail get thumbnail;
  @override
  _$CharacterCopyWith<_Character> get copyWith;
}

Thumbnail _$ThumbnailFromJson(Map<String, dynamic> json) {
  return _Thumbnatil.fromJson(json);
}

class _$ThumbnailTearOff {
  const _$ThumbnailTearOff();

// ignore: unused_element
  _Thumbnatil call({@required String path, @required String extension}) {
    return _Thumbnatil(
      path: path,
      extension: extension,
    );
  }
}

// ignore: unused_element
const $Thumbnail = _$ThumbnailTearOff();

mixin _$Thumbnail {
  String get path;
  String get extension;

  Map<String, dynamic> toJson();
  $ThumbnailCopyWith<Thumbnail> get copyWith;
}

abstract class $ThumbnailCopyWith<$Res> {
  factory $ThumbnailCopyWith(Thumbnail value, $Res Function(Thumbnail) then) =
      _$ThumbnailCopyWithImpl<$Res>;
  $Res call({String path, String extension});
}

class _$ThumbnailCopyWithImpl<$Res> implements $ThumbnailCopyWith<$Res> {
  _$ThumbnailCopyWithImpl(this._value, this._then);

  final Thumbnail _value;
  // ignore: unused_field
  final $Res Function(Thumbnail) _then;

  @override
  $Res call({
    Object path = freezed,
    Object extension = freezed,
  }) {
    return _then(_value.copyWith(
      path: path == freezed ? _value.path : path as String,
      extension: extension == freezed ? _value.extension : extension as String,
    ));
  }
}

abstract class _$ThumbnatilCopyWith<$Res> implements $ThumbnailCopyWith<$Res> {
  factory _$ThumbnatilCopyWith(
          _Thumbnatil value, $Res Function(_Thumbnatil) then) =
      __$ThumbnatilCopyWithImpl<$Res>;
  @override
  $Res call({String path, String extension});
}

class __$ThumbnatilCopyWithImpl<$Res> extends _$ThumbnailCopyWithImpl<$Res>
    implements _$ThumbnatilCopyWith<$Res> {
  __$ThumbnatilCopyWithImpl(
      _Thumbnatil _value, $Res Function(_Thumbnatil) _then)
      : super(_value, (v) => _then(v as _Thumbnatil));

  @override
  _Thumbnatil get _value => super._value as _Thumbnatil;

  @override
  $Res call({
    Object path = freezed,
    Object extension = freezed,
  }) {
    return _then(_Thumbnatil(
      path: path == freezed ? _value.path : path as String,
      extension: extension == freezed ? _value.extension : extension as String,
    ));
  }
}

@JsonSerializable()
class _$_Thumbnatil implements _Thumbnatil {
  _$_Thumbnatil({@required this.path, @required this.extension})
      : assert(path != null),
        assert(extension != null);

  factory _$_Thumbnatil.fromJson(Map<String, dynamic> json) =>
      _$_$_ThumbnatilFromJson(json);

  @override
  final String path;
  @override
  final String extension;

  bool _didurl = false;
  String _url;

  @override
  String get url {
    if (_didurl == false) {
      _didurl = true;
      _url = '${path.replaceFirst('http://', 'https://')}.$extension';
    }
    return _url;
  }

  @override
  String toString() {
    return 'Thumbnail(path: $path, extension: $extension, url: $url)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _Thumbnatil &&
            (identical(other.path, path) ||
                const DeepCollectionEquality().equals(other.path, path)) &&
            (identical(other.extension, extension) ||
                const DeepCollectionEquality()
                    .equals(other.extension, extension)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^
      const DeepCollectionEquality().hash(path) ^
      const DeepCollectionEquality().hash(extension);

  @override
  _$ThumbnatilCopyWith<_Thumbnatil> get copyWith =>
      __$ThumbnatilCopyWithImpl<_Thumbnatil>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$_$_ThumbnatilToJson(this);
  }
}

abstract class _Thumbnatil implements Thumbnail {
  factory _Thumbnatil({@required String path, @required String extension}) =
      _$_Thumbnatil;

  factory _Thumbnatil.fromJson(Map<String, dynamic> json) =
      _$_Thumbnatil.fromJson;

  @override
  String get path;
  @override
  String get extension;
  @override
  _$ThumbnatilCopyWith<_Thumbnatil> get copyWith;
}

MarvelResponse _$MarvelResponseFromJson(Map<String, dynamic> json) {
  return _MarvelResponse.fromJson(json);
}

class _$MarvelResponseTearOff {
  const _$MarvelResponseTearOff();

// ignore: unused_element
  _MarvelResponse call(MarvelData data) {
    return _MarvelResponse(
      data,
    );
  }
}

// ignore: unused_element
const $MarvelResponse = _$MarvelResponseTearOff();

mixin _$MarvelResponse {
  MarvelData get data;

  Map<String, dynamic> toJson();
  $MarvelResponseCopyWith<MarvelResponse> get copyWith;
}

abstract class $MarvelResponseCopyWith<$Res> {
  factory $MarvelResponseCopyWith(
          MarvelResponse value, $Res Function(MarvelResponse) then) =
      _$MarvelResponseCopyWithImpl<$Res>;
  $Res call({MarvelData data});

  $MarvelDataCopyWith<$Res> get data;
}

class _$MarvelResponseCopyWithImpl<$Res>
    implements $MarvelResponseCopyWith<$Res> {
  _$MarvelResponseCopyWithImpl(this._value, this._then);

  final MarvelResponse _value;
  // ignore: unused_field
  final $Res Function(MarvelResponse) _then;

  @override
  $Res call({
    Object data = freezed,
  }) {
    return _then(_value.copyWith(
      data: data == freezed ? _value.data : data as MarvelData,
    ));
  }

  @override
  $MarvelDataCopyWith<$Res> get data {
    if (_value.data == null) {
      return null;
    }
    return $MarvelDataCopyWith<$Res>(_value.data, (value) {
      return _then(_value.copyWith(data: value));
    });
  }
}

abstract class _$MarvelResponseCopyWith<$Res>
    implements $MarvelResponseCopyWith<$Res> {
  factory _$MarvelResponseCopyWith(
          _MarvelResponse value, $Res Function(_MarvelResponse) then) =
      __$MarvelResponseCopyWithImpl<$Res>;
  @override
  $Res call({MarvelData data});

  @override
  $MarvelDataCopyWith<$Res> get data;
}

class __$MarvelResponseCopyWithImpl<$Res>
    extends _$MarvelResponseCopyWithImpl<$Res>
    implements _$MarvelResponseCopyWith<$Res> {
  __$MarvelResponseCopyWithImpl(
      _MarvelResponse _value, $Res Function(_MarvelResponse) _then)
      : super(_value, (v) => _then(v as _MarvelResponse));

  @override
  _MarvelResponse get _value => super._value as _MarvelResponse;

  @override
  $Res call({
    Object data = freezed,
  }) {
    return _then(_MarvelResponse(
      data == freezed ? _value.data : data as MarvelData,
    ));
  }
}

@JsonSerializable()
class _$_MarvelResponse implements _MarvelResponse {
  _$_MarvelResponse(this.data) : assert(data != null);

  factory _$_MarvelResponse.fromJson(Map<String, dynamic> json) =>
      _$_$_MarvelResponseFromJson(json);

  @override
  final MarvelData data;

  @override
  String toString() {
    return 'MarvelResponse(data: $data)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _MarvelResponse &&
            (identical(other.data, data) ||
                const DeepCollectionEquality().equals(other.data, data)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^ const DeepCollectionEquality().hash(data);

  @override
  _$MarvelResponseCopyWith<_MarvelResponse> get copyWith =>
      __$MarvelResponseCopyWithImpl<_MarvelResponse>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$_$_MarvelResponseToJson(this);
  }
}

abstract class _MarvelResponse implements MarvelResponse {
  factory _MarvelResponse(MarvelData data) = _$_MarvelResponse;

  factory _MarvelResponse.fromJson(Map<String, dynamic> json) =
      _$_MarvelResponse.fromJson;

  @override
  MarvelData get data;
  @override
  _$MarvelResponseCopyWith<_MarvelResponse> get copyWith;
}

MarvelData _$MarvelDataFromJson(Map<String, dynamic> json) {
  return _MarvelData.fromJson(json);
}

class _$MarvelDataTearOff {
  const _$MarvelDataTearOff();

// ignore: unused_element
  _MarvelData call(List<Map<String, dynamic>> results, int total) {
    return _MarvelData(
      results,
      total,
    );
  }
}

// ignore: unused_element
const $MarvelData = _$MarvelDataTearOff();

mixin _$MarvelData {
  List<Map<String, dynamic>> get results;
  int get total;

  Map<String, dynamic> toJson();
  $MarvelDataCopyWith<MarvelData> get copyWith;
}

abstract class $MarvelDataCopyWith<$Res> {
  factory $MarvelDataCopyWith(
          MarvelData value, $Res Function(MarvelData) then) =
      _$MarvelDataCopyWithImpl<$Res>;
  $Res call({List<Map<String, dynamic>> results, int total});
}

class _$MarvelDataCopyWithImpl<$Res> implements $MarvelDataCopyWith<$Res> {
  _$MarvelDataCopyWithImpl(this._value, this._then);

  final MarvelData _value;
  // ignore: unused_field
  final $Res Function(MarvelData) _then;

  @override
  $Res call({
    Object results = freezed,
    Object total = freezed,
  }) {
    return _then(_value.copyWith(
      results: results == freezed
          ? _value.results
          : results as List<Map<String, dynamic>>,
      total: total == freezed ? _value.total : total as int,
    ));
  }
}

abstract class _$MarvelDataCopyWith<$Res> implements $MarvelDataCopyWith<$Res> {
  factory _$MarvelDataCopyWith(
          _MarvelData value, $Res Function(_MarvelData) then) =
      __$MarvelDataCopyWithImpl<$Res>;
  @override
  $Res call({List<Map<String, dynamic>> results, int total});
}

class __$MarvelDataCopyWithImpl<$Res> extends _$MarvelDataCopyWithImpl<$Res>
    implements _$MarvelDataCopyWith<$Res> {
  __$MarvelDataCopyWithImpl(
      _MarvelData _value, $Res Function(_MarvelData) _then)
      : super(_value, (v) => _then(v as _MarvelData));

  @override
  _MarvelData get _value => super._value as _MarvelData;

  @override
  $Res call({
    Object results = freezed,
    Object total = freezed,
  }) {
    return _then(_MarvelData(
      results == freezed
          ? _value.results
          : results as List<Map<String, dynamic>>,
      total == freezed ? _value.total : total as int,
    ));
  }
}

@JsonSerializable()
class _$_MarvelData implements _MarvelData {
  _$_MarvelData(this.results, this.total)
      : assert(results != null),
        assert(total != null);

  factory _$_MarvelData.fromJson(Map<String, dynamic> json) =>
      _$_$_MarvelDataFromJson(json);

  @override
  final List<Map<String, dynamic>> results;
  @override
  final int total;

  @override
  String toString() {
    return 'MarvelData(results: $results, total: $total)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is _MarvelData &&
            (identical(other.results, results) ||
                const DeepCollectionEquality()
                    .equals(other.results, results)) &&
            (identical(other.total, total) ||
                const DeepCollectionEquality().equals(other.total, total)));
  }

  @override
  int get hashCode =>
      runtimeType.hashCode ^
      const DeepCollectionEquality().hash(results) ^
      const DeepCollectionEquality().hash(total);

  @override
  _$MarvelDataCopyWith<_MarvelData> get copyWith =>
      __$MarvelDataCopyWithImpl<_MarvelData>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$_$_MarvelDataToJson(this);
  }
}

abstract class _MarvelData implements MarvelData {
  factory _MarvelData(List<Map<String, dynamic>> results, int total) =
      _$_MarvelData;

  factory _MarvelData.fromJson(Map<String, dynamic> json) =
      _$_MarvelData.fromJson;

  @override
  List<Map<String, dynamic>> get results;
  @override
  int get total;
  @override
  _$MarvelDataCopyWith<_MarvelData> get copyWith;
}
