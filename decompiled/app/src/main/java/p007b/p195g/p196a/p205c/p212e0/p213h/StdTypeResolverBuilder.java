package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.p212e0.DefaultBaseTypeLimitingValidator;
import p007b.p195g.p196a.p205c.p212e0.NamedType;
import p007b.p195g.p196a.p205c.p212e0.PolymorphicTypeValidator;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* compiled from: StdTypeResolverBuilder.java */
/* renamed from: b.g.a.c.e0.h.j, reason: use source file name */
/* loaded from: classes3.dex */
public class StdTypeResolverBuilder implements TypeResolverBuilder<StdTypeResolverBuilder> {
    public TypeIdResolver _customIdResolver;
    public JsonTypeInfo.b _idType;
    public JsonTypeInfo.a _includeAs;
    public String _typeProperty;

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder
    /* renamed from: a */
    public TypeResolverBuilder mo1949a(boolean z2) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder
    /* renamed from: b */
    public /* bridge */ /* synthetic */ TypeResolverBuilder mo1950b(JsonTypeInfo.b bVar, TypeIdResolver typeIdResolver) {
        m1966g(bVar, typeIdResolver);
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder
    /* renamed from: c */
    public TypeResolverBuilder mo1951c(String str) {
        if (str == null || str.isEmpty()) {
            str = this._idType.m1594f();
        }
        this._typeProperty = str;
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder
    /* renamed from: d */
    public TypeResolverBuilder mo1952d(Class cls) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder
    /* renamed from: e */
    public TypeSerializer mo1953e(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this._idType == JsonTypeInfo.b.NONE || javaType._class.isPrimitive()) {
            return null;
        }
        PolymorphicTypeValidator defaultBaseTypeLimitingValidator = serializationConfig._base._typeValidator;
        if (defaultBaseTypeLimitingValidator == LaissezFaireSubTypeValidator.f4772j && serializationConfig.m2279q(MapperFeature.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            defaultBaseTypeLimitingValidator = new DefaultBaseTypeLimitingValidator();
        }
        TypeIdResolver classNameIdResolver = this._customIdResolver;
        if (classNameIdResolver == null) {
            JsonTypeInfo.b bVar = this._idType;
            if (bVar == null) {
                throw new IllegalStateException("Cannot build, 'init()' not yet called");
            }
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 0) {
                classNameIdResolver = null;
            } else if (iOrdinal == 1) {
                classNameIdResolver = new ClassNameIdResolver(javaType, serializationConfig._base._typeFactory, defaultBaseTypeLimitingValidator);
            } else if (iOrdinal == 2) {
                classNameIdResolver = new MinimalClassNameIdResolver(javaType, serializationConfig._base._typeFactory, defaultBaseTypeLimitingValidator);
            } else if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    StringBuilder sbM833U = outline.m833U("Do not know how to construct standard type id resolver for idType: ");
                    sbM833U.append(this._idType);
                    throw new IllegalStateException(sbM833U.toString());
                }
                classNameIdResolver = new ClassNameIdResolver(javaType, serializationConfig._base._typeFactory, defaultBaseTypeLimitingValidator);
            } else {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                serializationConfig.m2279q(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (collection != null) {
                    for (NamedType namedType : collection) {
                        Class<?> cls = namedType._class;
                        concurrentHashMap.put(cls.getName(), namedType.m1944a() ? namedType._name : TypeNameIdResolver.m1967d(cls));
                    }
                }
                classNameIdResolver = new TypeNameIdResolver(serializationConfig, javaType, concurrentHashMap, null);
            }
        }
        if (this._idType == JsonTypeInfo.b.DEDUCTION) {
            return new AsExistingPropertyTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        int iOrdinal2 = this._includeAs.ordinal();
        if (iOrdinal2 == 0) {
            return new AsPropertyTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        if (iOrdinal2 == 1) {
            return new AsWrapperTypeSerializer(classNameIdResolver, null);
        }
        if (iOrdinal2 == 2) {
            return new AsArrayTypeSerializer(classNameIdResolver, null);
        }
        if (iOrdinal2 == 3) {
            return new AsExternalTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        if (iOrdinal2 == 4) {
            return new AsExistingPropertyTypeSerializer(classNameIdResolver, null, this._typeProperty);
        }
        StringBuilder sbM833U2 = outline.m833U("Do not know how to construct standard type serializer for inclusion type: ");
        sbM833U2.append(this._includeAs);
        throw new IllegalStateException(sbM833U2.toString());
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder
    /* renamed from: f */
    public TypeResolverBuilder mo1954f(JsonTypeInfo.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this._includeAs = aVar;
        return this;
    }

    /* renamed from: g */
    public StdTypeResolverBuilder m1966g(JsonTypeInfo.b bVar, TypeIdResolver typeIdResolver) {
        if (bVar == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this._idType = bVar;
        this._customIdResolver = typeIdResolver;
        this._typeProperty = bVar.m1594f();
        return this;
    }
}
