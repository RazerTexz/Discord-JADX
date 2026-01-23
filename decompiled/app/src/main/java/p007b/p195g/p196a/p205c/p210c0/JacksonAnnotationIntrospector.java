package p007b.p195g.p196a.p205c.p210c0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JacksonAnnotationsInside;
import p007b.p195g.p196a.p197a.JacksonInject;
import p007b.p195g.p196a.p197a.JsonAnyGetter;
import p007b.p195g.p196a.p197a.JsonAnySetter;
import p007b.p195g.p196a.p197a.JsonAutoDetect;
import p007b.p195g.p196a.p197a.JsonBackReference;
import p007b.p195g.p196a.p197a.JsonCreator;
import p007b.p195g.p196a.p197a.JsonFilter;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonGetter;
import p007b.p195g.p196a.p197a.JsonIdentityInfo;
import p007b.p195g.p196a.p197a.JsonIdentityReference;
import p007b.p195g.p196a.p197a.JsonIgnore;
import p007b.p195g.p196a.p197a.JsonIgnoreProperties;
import p007b.p195g.p196a.p197a.JsonIgnoreType;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p197a.JsonIncludeProperties;
import p007b.p195g.p196a.p197a.JsonKey;
import p007b.p195g.p196a.p197a.JsonManagedReference;
import p007b.p195g.p196a.p197a.JsonMerge;
import p007b.p195g.p196a.p197a.JsonProperty;
import p007b.p195g.p196a.p197a.JsonPropertyDescription;
import p007b.p195g.p196a.p197a.JsonPropertyOrder;
import p007b.p195g.p196a.p197a.JsonRawValue;
import p007b.p195g.p196a.p197a.JsonRootName;
import p007b.p195g.p196a.p197a.JsonSetter;
import p007b.p195g.p196a.p197a.JsonSubTypes;
import p007b.p195g.p196a.p197a.JsonTypeId;
import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p197a.JsonTypeName;
import p007b.p195g.p196a.p197a.JsonUnwrapped;
import p007b.p195g.p196a.p197a.JsonValue;
import p007b.p195g.p196a.p197a.JsonView;
import p007b.p195g.p196a.p197a.Nulls;
import p007b.p195g.p196a.p197a.ObjectIdGenerators2;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p209b0.Java7Support;
import p007b.p195g.p196a.p205c.p210c0.VisibilityChecker;
import p007b.p195g.p196a.p205c.p212e0.NamedType;
import p007b.p195g.p196a.p205c.p212e0.TypeIdResolver;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;
import p007b.p195g.p196a.p205c.p212e0.p213h.StdTypeResolverBuilder;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.VirtualBeanPropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.p216t.AttributePropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.p217u.RawSerializer;
import p007b.p195g.p196a.p205c.p218h0.ClassStack;
import p007b.p195g.p196a.p205c.p218h0.MapLikeType;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.Converter;
import p007b.p195g.p196a.p205c.p219i0.LRUMap;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer2;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer3;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;
import p007b.p195g.p196a.p205c.p219i0.SimpleBeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p220y.JsonAppend;
import p007b.p195g.p196a.p205c.p220y.JsonDeserialize;
import p007b.p195g.p196a.p205c.p220y.JsonNaming;
import p007b.p195g.p196a.p205c.p220y.JsonSerialize;
import p007b.p195g.p196a.p205c.p220y.JsonTypeIdResolver;
import p007b.p195g.p196a.p205c.p220y.JsonTypeResolver;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.c0.x, reason: use source file name */
/* JADX INFO: compiled from: JacksonAnnotationIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Class<? extends Annotation>[] f4757j = {JsonSerialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonRawValue.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class};

    /* JADX INFO: renamed from: k */
    public static final Class<? extends Annotation>[] f4758k = {JsonDeserialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class, JsonMerge.class};

    /* JADX INFO: renamed from: l */
    public static final Java7Support f4759l;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: m */
    public transient LRUMap<Class<?>, Boolean> f4760m = new LRUMap<>(48, 48);
    public boolean _cfgConstructorPropertiesImpliesCreator = true;

    static {
        Java7Support java7Support;
        try {
            java7Support = Java7Support.f4622a;
        } catch (Throwable unused) {
            java7Support = null;
        }
        f4759l = java7Support;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashSet] */
    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: A */
    public JsonIncludeProperties.a mo1745A(MapperConfig<?> mapperConfig, Annotated annotated) {
        ?? EmptySet;
        JsonIncludeProperties jsonIncludeProperties = (JsonIncludeProperties) annotated.mo1818b(JsonIncludeProperties.class);
        if (jsonIncludeProperties == null) {
            return JsonIncludeProperties.a.f4437j;
        }
        String[] strArrValue = jsonIncludeProperties.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return new JsonIncludeProperties.a(EmptySet);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: B */
    public Integer mo1746B(Annotated annotated) {
        int iIndex;
        JsonProperty jsonProperty = (JsonProperty) annotated.mo1818b(JsonProperty.class);
        if (jsonProperty == null || (iIndex = jsonProperty.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: C */
    public TypeResolverBuilder<?> mo1747C(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.mo2104v() || javaType.mo1728b()) {
            return null;
        }
        return m1934h0(mapperConfig, annotatedMember, javaType);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: D */
    public AnnotationIntrospector.a mo1748D(AnnotatedMember annotatedMember) {
        JsonManagedReference jsonManagedReference = (JsonManagedReference) annotatedMember.mo1818b(JsonManagedReference.class);
        if (jsonManagedReference != null) {
            return new AnnotationIntrospector.a(1, jsonManagedReference.value());
        }
        JsonBackReference jsonBackReference = (JsonBackReference) annotatedMember.mo1818b(JsonBackReference.class);
        if (jsonBackReference != null) {
            return new AnnotationIntrospector.a(2, jsonBackReference.value());
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: E */
    public PropertyName mo1749E(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, PropertyName propertyName) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: F */
    public PropertyName mo1750F(AnnotatedClass annotatedClass) {
        JsonRootName jsonRootName = (JsonRootName) annotatedClass.mo1818b(JsonRootName.class);
        if (jsonRootName == null) {
            return null;
        }
        String strNamespace = jsonRootName.namespace();
        return PropertyName.m2228b(jsonRootName.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: G */
    public Object mo1751G(AnnotatedMember annotatedMember) {
        Class<?> clsM1933g0;
        JsonSerialize jsonSerialize = (JsonSerialize) annotatedMember.mo1818b(JsonSerialize.class);
        if (jsonSerialize == null || (clsM1933g0 = m1933g0(jsonSerialize.contentConverter())) == null || clsM1933g0 == Converter.a.class) {
            return null;
        }
        return clsM1933g0;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: H */
    public Object mo1752H(Annotated annotated) {
        Class<?> clsM1933g0;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class);
        if (jsonSerialize == null || (clsM1933g0 = m1933g0(jsonSerialize.converter())) == null || clsM1933g0 == Converter.a.class) {
            return null;
        }
        return clsM1933g0;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: I */
    public String[] mo1753I(AnnotatedClass annotatedClass) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotatedClass.mo1818b(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null) {
            return null;
        }
        return jsonPropertyOrder.value();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: J */
    public Boolean mo1754J(Annotated annotated) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotated.mo1818b(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null || !jsonPropertyOrder.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: K */
    public JsonSerialize.b mo1755K(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return jsonSerialize.typing();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: L */
    public Object mo1756L(Annotated annotated) {
        Class<? extends JsonSerializer> clsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class);
        if (jsonSerialize != null && (clsUsing = jsonSerialize.using()) != JsonSerializer.a.class) {
            return clsUsing;
        }
        JsonRawValue jsonRawValue = (JsonRawValue) annotated.mo1818b(JsonRawValue.class);
        if (jsonRawValue == null || !jsonRawValue.value()) {
            return null;
        }
        return new RawSerializer(annotated.mo1820d());
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: M */
    public JsonSetter.a mo1757M(Annotated annotated) {
        JsonSetter jsonSetter = (JsonSetter) annotated.mo1818b(JsonSetter.class);
        if (jsonSetter == null) {
            return JsonSetter.a.f4443j;
        }
        Nulls nulls = jsonSetter.nulls();
        Nulls nullsContentNulls = jsonSetter.contentNulls();
        Nulls nulls2 = Nulls.DEFAULT;
        if (nulls == null) {
            nulls = nulls2;
        }
        if (nullsContentNulls == null) {
            nullsContentNulls = nulls2;
        }
        return nulls == nulls2 && nullsContentNulls == nulls2 ? JsonSetter.a.f4443j : new JsonSetter.a(nulls, nullsContentNulls);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: N */
    public List<NamedType> mo1758N(Annotated annotated) {
        JsonSubTypes jsonSubTypes = (JsonSubTypes) annotated.mo1818b(JsonSubTypes.class);
        if (jsonSubTypes == null) {
            return null;
        }
        JsonSubTypes.a[] aVarArrValue = jsonSubTypes.value();
        ArrayList arrayList = new ArrayList(aVarArrValue.length);
        for (JsonSubTypes.a aVar : aVarArrValue) {
            arrayList.add(new NamedType(aVar.value(), aVar.name()));
            for (String str : aVar.names()) {
                arrayList.add(new NamedType(aVar.value(), str));
            }
        }
        return arrayList;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: O */
    public String mo1759O(AnnotatedClass annotatedClass) {
        JsonTypeName jsonTypeName = (JsonTypeName) annotatedClass.mo1818b(JsonTypeName.class);
        if (jsonTypeName == null) {
            return null;
        }
        return jsonTypeName.value();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: P */
    public TypeResolverBuilder<?> mo1760P(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return m1934h0(mapperConfig, annotatedClass, javaType);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: Q */
    public NameTransformer4 mo1761Q(AnnotatedMember annotatedMember) {
        JsonUnwrapped jsonUnwrapped = (JsonUnwrapped) annotatedMember.mo1818b(JsonUnwrapped.class);
        if (jsonUnwrapped == null || !jsonUnwrapped.enabled()) {
            return null;
        }
        String strPrefix = jsonUnwrapped.prefix();
        String strSuffix = jsonUnwrapped.suffix();
        boolean z2 = false;
        boolean z3 = (strPrefix == null || strPrefix.isEmpty()) ? false : true;
        if (strSuffix != null && !strSuffix.isEmpty()) {
            z2 = true;
        }
        return z3 ? z2 ? new NameTransformer(strPrefix, strSuffix) : new NameTransformer2(strPrefix) : z2 ? new NameTransformer3(strSuffix) : NameTransformer4.f4961j;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: R */
    public Class<?>[] mo1762R(Annotated annotated) {
        JsonView jsonView = (JsonView) annotated.mo1818b(JsonView.class);
        if (jsonView == null) {
            return null;
        }
        return jsonView.value();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: S */
    public Boolean mo1763S(Annotated annotated) {
        JsonAnyGetter jsonAnyGetter = (JsonAnyGetter) annotated.mo1818b(JsonAnyGetter.class);
        if (jsonAnyGetter == null) {
            return null;
        }
        return Boolean.valueOf(jsonAnyGetter.enabled());
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    @Deprecated
    /* JADX INFO: renamed from: T */
    public boolean mo1764T(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.m1904k(JsonAnyGetter.class);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: U */
    public Boolean mo1765U(Annotated annotated) {
        JsonAnySetter jsonAnySetter = (JsonAnySetter) annotated.mo1818b(JsonAnySetter.class);
        if (jsonAnySetter == null) {
            return null;
        }
        return Boolean.valueOf(jsonAnySetter.enabled());
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: V */
    public Boolean mo1766V(MapperConfig<?> mapperConfig, Annotated annotated) {
        JsonKey jsonKey = (JsonKey) annotated.mo1818b(JsonKey.class);
        if (jsonKey == null) {
            return null;
        }
        return Boolean.valueOf(jsonKey.value());
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: W */
    public Boolean mo1767W(Annotated annotated) {
        JsonValue jsonValue = (JsonValue) annotated.mo1818b(JsonValue.class);
        if (jsonValue == null) {
            return null;
        }
        return Boolean.valueOf(jsonValue.value());
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    @Deprecated
    /* JADX INFO: renamed from: X */
    public boolean mo1768X(AnnotatedMethod annotatedMethod) {
        JsonValue jsonValue = (JsonValue) annotatedMethod.mo1818b(JsonValue.class);
        return jsonValue != null && jsonValue.value();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    @Deprecated
    /* JADX INFO: renamed from: Y */
    public boolean mo1769Y(Annotated annotated) {
        Java7Support java7Support;
        Boolean boolMo1806c;
        JsonCreator jsonCreator = (JsonCreator) annotated.mo1818b(JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode() != JsonCreator.a.DISABLED;
        }
        if (!this._cfgConstructorPropertiesImpliesCreator || !(annotated instanceof AnnotatedConstructor) || (java7Support = f4759l) == null || (boolMo1806c = java7Support.mo1806c(annotated)) == null) {
            return false;
        }
        return boolMo1806c.booleanValue();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: Z */
    public boolean mo1770Z(AnnotatedMember annotatedMember) {
        Boolean boolMo1805b;
        JsonIgnore jsonIgnore = (JsonIgnore) annotatedMember.mo1818b(JsonIgnore.class);
        if (jsonIgnore != null) {
            return jsonIgnore.value();
        }
        Java7Support java7Support = f4759l;
        if (java7Support == null || (boolMo1805b = java7Support.mo1805b(annotatedMember)) == null) {
            return false;
        }
        return boolMo1805b.booleanValue();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: a */
    public void mo1771a(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<BeanPropertyWriter> list) {
        JsonAppend jsonAppend = (JsonAppend) annotatedClass.f4663t.mo1915a(JsonAppend.class);
        if (jsonAppend == null) {
            return;
        }
        boolean zPrepend = jsonAppend.prepend();
        JsonAppend.a[] aVarArrAttrs = jsonAppend.attrs();
        int length = aVarArrAttrs.length;
        ClassStack classStack = null;
        JavaType javaTypeM2160b = null;
        int i = 0;
        while (i < length) {
            if (javaTypeM2160b == null) {
                javaTypeM2160b = mapperConfig._base._typeFactory.m2160b(classStack, Object.class, TypeFactory.f4926l);
            }
            JsonAppend.a aVar = aVarArrAttrs[i];
            PropertyMetadata propertyMetadata = aVar.required() ? PropertyMetadata.f5025j : PropertyMetadata.f5026k;
            String strValue = aVar.value();
            PropertyName propertyNameM1936j0 = m1936j0(aVar.propName(), aVar.propNamespace());
            if (!propertyNameM1936j0.m2229c()) {
                propertyNameM1936j0 = PropertyName.m2227a(strValue);
            }
            AttributePropertyWriter attributePropertyWriter = new AttributePropertyWriter(strValue, SimpleBeanPropertyDefinition.m2203w(mapperConfig, new VirtualAnnotatedMember(annotatedClass, annotatedClass.f4655l, strValue, javaTypeM2160b), propertyNameM1936j0, propertyMetadata, aVar.include()), annotatedClass.f4663t, javaTypeM2160b);
            if (zPrepend) {
                list.add(i, attributePropertyWriter);
            } else {
                list.add(attributePropertyWriter);
            }
            i++;
            classStack = null;
        }
        JsonAppend.b[] bVarArrProps = jsonAppend.props();
        int length2 = bVarArrProps.length;
        for (int i2 = 0; i2 < length2; i2++) {
            JsonAppend.b bVar = bVarArrProps[i2];
            PropertyMetadata propertyMetadata2 = bVar.required() ? PropertyMetadata.f5025j : PropertyMetadata.f5026k;
            PropertyName propertyNameM1936j02 = m1936j0(bVar.name(), bVar.namespace());
            JavaType javaTypeM2266d = mapperConfig.m2266d(bVar.type());
            SimpleBeanPropertyDefinition simpleBeanPropertyDefinitionM2203w = SimpleBeanPropertyDefinition.m2203w(mapperConfig, new VirtualAnnotatedMember(annotatedClass, annotatedClass.f4655l, propertyNameM1936j02._simpleName, javaTypeM2266d), propertyNameM1936j02, propertyMetadata2, bVar.include());
            Class<? extends VirtualBeanPropertyWriter> clsValue = bVar.value();
            Objects.requireNonNull(mapperConfig._base);
            VirtualBeanPropertyWriter virtualBeanPropertyWriterMo2018k = ((VirtualBeanPropertyWriter) ClassUtil.m2175g(clsValue, mapperConfig.m2265b())).mo2018k(mapperConfig, annotatedClass, simpleBeanPropertyDefinitionM2203w, javaTypeM2266d);
            if (zPrepend) {
                list.add(i2, virtualBeanPropertyWriterMo2018k);
            } else {
                list.add(virtualBeanPropertyWriterMo2018k);
            }
        }
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: a0 */
    public Boolean mo1772a0(AnnotatedMember annotatedMember) {
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.mo1818b(JsonProperty.class);
        if (jsonProperty != null) {
            return Boolean.valueOf(jsonProperty.required());
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: b */
    public VisibilityChecker<?> mo1773b(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        JsonAutoDetect jsonAutoDetect = (JsonAutoDetect) annotatedClass.mo1818b(JsonAutoDetect.class);
        if (jsonAutoDetect == null) {
            return visibilityChecker;
        }
        VisibilityChecker.a aVar = (VisibilityChecker.a) visibilityChecker;
        Objects.requireNonNull(aVar);
        return aVar.m1899b(aVar.m1898a(aVar._getterMinLevel, jsonAutoDetect.getterVisibility()), aVar.m1898a(aVar._isGetterMinLevel, jsonAutoDetect.isGetterVisibility()), aVar.m1898a(aVar._setterMinLevel, jsonAutoDetect.setterVisibility()), aVar.m1898a(aVar._creatorMinLevel, jsonAutoDetect.creatorVisibility()), aVar.m1898a(aVar._fieldMinLevel, jsonAutoDetect.fieldVisibility()));
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: b0 */
    public boolean mo1774b0(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Boolean boolValueOf = this.f4760m.get(clsAnnotationType);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(JacksonAnnotationsInside.class) != null);
            this.f4760m.putIfAbsent(clsAnnotationType, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: c */
    public Object mo1775c(Annotated annotated) {
        Class<? extends JsonSerializer> clsContentUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class);
        if (jsonSerialize == null || (clsContentUsing = jsonSerialize.contentUsing()) == JsonSerializer.a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: c0 */
    public Boolean mo1776c0(AnnotatedClass annotatedClass) {
        JsonIgnoreType jsonIgnoreType = (JsonIgnoreType) annotatedClass.mo1818b(JsonIgnoreType.class);
        if (jsonIgnoreType == null) {
            return null;
        }
        return Boolean.valueOf(jsonIgnoreType.value());
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: d */
    public JsonCreator.a mo1777d(MapperConfig<?> mapperConfig, Annotated annotated) {
        Java7Support java7Support;
        Boolean boolMo1806c;
        JsonCreator jsonCreator = (JsonCreator) annotated.mo1818b(JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode();
        }
        if (this._cfgConstructorPropertiesImpliesCreator && mapperConfig.m2279q(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES) && (annotated instanceof AnnotatedConstructor) && (java7Support = f4759l) != null && (boolMo1806c = java7Support.mo1806c(annotated)) != null && boolMo1806c.booleanValue()) {
            return JsonCreator.a.PROPERTIES;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: d0 */
    public Boolean mo1778d0(AnnotatedMember annotatedMember) {
        return Boolean.valueOf(annotatedMember.m1904k(JsonTypeId.class));
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    @Deprecated
    /* JADX INFO: renamed from: e */
    public JsonCreator.a mo1779e(Annotated annotated) {
        JsonCreator jsonCreator = (JsonCreator) annotated.mo1818b(JsonCreator.class);
        if (jsonCreator == null) {
            return null;
        }
        return jsonCreator.mode();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: e0 */
    public JavaType mo1780e0(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeMo2096G;
        JavaType javaTypeMo2096G2;
        TypeFactory typeFactory = mapperConfig._base._typeFactory;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class);
        Class<?> clsM1933g0 = jsonSerialize == null ? null : m1933g0(jsonSerialize.m2262as());
        if (clsM1933g0 != null) {
            Class<?> cls = javaType._class;
            if (cls == clsM1933g0) {
                javaType = javaType.mo2096G();
            } else {
                try {
                    if (clsM1933g0.isAssignableFrom(cls)) {
                        javaType = typeFactory.m2165g(javaType, clsM1933g0);
                    } else if (cls.isAssignableFrom(clsM1933g0)) {
                        javaType = typeFactory.m2166h(javaType, clsM1933g0, false);
                    } else {
                        if (!m1935i0(cls, clsM1933g0)) {
                            throw new JsonMappingException(null, String.format("Cannot refine serialization type %s into %s; types not related", javaType, clsM1933g0.getName()));
                        }
                        javaType = javaType.mo2096G();
                    }
                } catch (IllegalArgumentException e) {
                    throw new JsonMappingException(null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", javaType, clsM1933g0.getName(), annotated.mo1819c(), e.getMessage()), e);
                }
            }
        }
        if (javaType.mo2122z()) {
            JavaType javaTypeMo2121o = javaType.mo2121o();
            Class<?> clsM1933g02 = jsonSerialize == null ? null : m1933g0(jsonSerialize.keyAs());
            if (clsM1933g02 != null) {
                Class<?> cls2 = javaTypeMo2121o._class;
                if (cls2 == clsM1933g02) {
                    javaTypeMo2096G2 = javaTypeMo2121o.mo2096G();
                } else {
                    try {
                        if (clsM1933g02.isAssignableFrom(cls2)) {
                            javaTypeMo2096G2 = typeFactory.m2165g(javaTypeMo2121o, clsM1933g02);
                        } else if (cls2.isAssignableFrom(clsM1933g02)) {
                            javaTypeMo2096G2 = typeFactory.m2166h(javaTypeMo2121o, clsM1933g02, false);
                        } else {
                            if (!m1935i0(cls2, clsM1933g02)) {
                                throw new JsonMappingException(null, String.format("Cannot refine serialization key type %s into %s; types not related", javaTypeMo2121o, clsM1933g02.getName()));
                            }
                            javaTypeMo2096G2 = javaTypeMo2121o.mo2096G();
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new JsonMappingException(null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsM1933g02.getName(), annotated.mo1819c(), e2.getMessage()), e2);
                    }
                }
                javaType = ((MapLikeType) javaType).mo2117M(javaTypeMo2096G2);
            }
        }
        JavaType javaTypeMo2099k = javaType.mo2099k();
        if (javaTypeMo2099k == null) {
            return javaType;
        }
        Class<?> clsM1933g03 = jsonSerialize == null ? null : m1933g0(jsonSerialize.contentAs());
        if (clsM1933g03 == null) {
            return javaType;
        }
        Class<?> cls3 = javaTypeMo2099k._class;
        if (cls3 == clsM1933g03) {
            javaTypeMo2096G = javaTypeMo2099k.mo2096G();
        } else {
            try {
                if (clsM1933g03.isAssignableFrom(cls3)) {
                    javaTypeMo2096G = typeFactory.m2165g(javaTypeMo2099k, clsM1933g03);
                } else if (cls3.isAssignableFrom(clsM1933g03)) {
                    javaTypeMo2096G = typeFactory.m2166h(javaTypeMo2099k, clsM1933g03, false);
                } else {
                    if (!m1935i0(cls3, clsM1933g03)) {
                        throw new JsonMappingException(null, String.format("Cannot refine serialization content type %s into %s; types not related", javaTypeMo2099k, clsM1933g03.getName()));
                    }
                    javaTypeMo2096G = javaTypeMo2099k.mo2096G();
                }
            } catch (IllegalArgumentException e3) {
                throw new JsonMappingException(null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsM1933g03.getName(), annotated.mo1819c(), e3.getMessage()), e3);
            }
        }
        return javaType.mo2094D(javaTypeMo2096G);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: f */
    public String[] mo1781f(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        JsonProperty jsonProperty;
        HashMap map = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (jsonProperty = (JsonProperty) field.getAnnotation(JsonProperty.class)) != null) {
                String strValue = jsonProperty.value();
                if (!strValue.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(field.getName(), strValue);
                }
            }
        }
        if (map != null) {
            int length = enumArr.length;
            for (int i = 0; i < length; i++) {
                String str = (String) map.get(enumArr[i].name());
                if (str != null) {
                    strArr[i] = str;
                }
            }
        }
        return strArr;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: f0 */
    public AnnotatedMethod mo1782f0(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        Class<?> clsM1906p = annotatedMethod.m1906p(0);
        Class<?> clsM1906p2 = annotatedMethod2.m1906p(0);
        if (clsM1906p.isPrimitive()) {
            if (!clsM1906p2.isPrimitive()) {
                return annotatedMethod;
            }
        } else if (clsM1906p2.isPrimitive()) {
            return annotatedMethod2;
        }
        if (clsM1906p == String.class) {
            if (clsM1906p2 != String.class) {
                return annotatedMethod;
            }
            return null;
        }
        if (clsM1906p2 == String.class) {
            return annotatedMethod2;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: g */
    public Object mo1783g(Annotated annotated) {
        JsonFilter jsonFilter = (JsonFilter) annotated.mo1818b(JsonFilter.class);
        if (jsonFilter == null) {
            return null;
        }
        String strValue = jsonFilter.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    /* JADX INFO: renamed from: g0 */
    public Class<?> m1933g0(Class<?> cls) {
        if (cls == null || ClassUtil.m2184p(cls)) {
            return null;
        }
        return cls;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: h */
    public JsonFormat.d mo1784h(Annotated annotated) {
        JsonFormat jsonFormat = (JsonFormat) annotated.mo1818b(JsonFormat.class);
        if (jsonFormat == null) {
            return null;
        }
        String strPattern = jsonFormat.pattern();
        JsonFormat.c cVarShape = jsonFormat.shape();
        String strLocale = jsonFormat.locale();
        String strTimezone = jsonFormat.timezone();
        JsonFormat.a[] aVarArrWith = jsonFormat.with();
        JsonFormat.a[] aVarArrWithout = jsonFormat.without();
        int iOrdinal = 0;
        for (JsonFormat.a aVar : aVarArrWith) {
            iOrdinal |= 1 << aVar.ordinal();
        }
        int iOrdinal2 = 0;
        for (JsonFormat.a aVar2 : aVarArrWithout) {
            iOrdinal2 |= 1 << aVar2.ordinal();
        }
        return new JsonFormat.d(strPattern, cVarShape, strLocale, strTimezone, new JsonFormat.b(iOrdinal, iOrdinal2), jsonFormat.lenient().m1613f());
    }

    /* JADX INFO: renamed from: h0 */
    public TypeResolverBuilder<?> m1934h0(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) {
        TypeResolverBuilder stdTypeResolverBuilder;
        JsonTypeInfo jsonTypeInfo = (JsonTypeInfo) annotated.mo1818b(JsonTypeInfo.class);
        JsonTypeResolver jsonTypeResolver = (JsonTypeResolver) annotated.mo1818b(JsonTypeResolver.class);
        TypeIdResolver typeIdResolver = null;
        if (jsonTypeResolver != null) {
            if (jsonTypeInfo == null) {
                return null;
            }
            Class<? extends TypeResolverBuilder<?>> clsValue = jsonTypeResolver.value();
            Objects.requireNonNull(mapperConfig._base);
            stdTypeResolverBuilder = (TypeResolverBuilder) ClassUtil.m2175g(clsValue, mapperConfig.m2265b());
        } else {
            if (jsonTypeInfo == null) {
                return null;
            }
            JsonTypeInfo.b bVarUse = jsonTypeInfo.use();
            JsonTypeInfo.b bVar = JsonTypeInfo.b.NONE;
            if (bVarUse == bVar) {
                StdTypeResolverBuilder stdTypeResolverBuilder2 = new StdTypeResolverBuilder();
                stdTypeResolverBuilder2.m1966g(bVar, null);
                return stdTypeResolverBuilder2;
            }
            stdTypeResolverBuilder = new StdTypeResolverBuilder();
        }
        JsonTypeIdResolver jsonTypeIdResolver = (JsonTypeIdResolver) annotated.mo1818b(JsonTypeIdResolver.class);
        if (jsonTypeIdResolver != null) {
            Class<? extends TypeIdResolver> clsValue2 = jsonTypeIdResolver.value();
            Objects.requireNonNull(mapperConfig._base);
            typeIdResolver = (TypeIdResolver) ClassUtil.m2175g(clsValue2, mapperConfig.m2265b());
        }
        if (typeIdResolver != null) {
            typeIdResolver.mo1947b(javaType);
        }
        TypeResolverBuilder typeResolverBuilderMo1950b = stdTypeResolverBuilder.mo1950b(jsonTypeInfo.use(), typeIdResolver);
        JsonTypeInfo.a aVarInclude = jsonTypeInfo.include();
        if (aVarInclude == JsonTypeInfo.a.EXTERNAL_PROPERTY && (annotated instanceof AnnotatedClass)) {
            aVarInclude = JsonTypeInfo.a.PROPERTY;
        }
        TypeResolverBuilder typeResolverBuilderMo1951c = typeResolverBuilderMo1950b.mo1954f(aVarInclude).mo1951c(jsonTypeInfo.property());
        Class<?> clsDefaultImpl = jsonTypeInfo.defaultImpl();
        if (clsDefaultImpl != JsonTypeInfo.c.class && !clsDefaultImpl.isAnnotation()) {
            typeResolverBuilderMo1951c = typeResolverBuilderMo1951c.mo1952d(clsDefaultImpl);
        }
        return typeResolverBuilderMo1951c.mo1949a(jsonTypeInfo.visible());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String mo1785i(AnnotatedMember annotatedMember) {
        PropertyName propertyNameMo1804a;
        Java7Support java7Support;
        if (annotatedMember instanceof AnnotatedParameter) {
            AnnotatedParameter annotatedParameter = (AnnotatedParameter) annotatedMember;
            if (annotatedParameter._owner == null || (java7Support = f4759l) == null || (propertyNameMo1804a = java7Support.mo1804a(annotatedParameter)) == null) {
                propertyNameMo1804a = null;
            }
        }
        if (propertyNameMo1804a == null) {
            return null;
        }
        return propertyNameMo1804a._simpleName;
    }

    /* JADX INFO: renamed from: i0 */
    public final boolean m1935i0(Class<?> cls, Class<?> cls2) {
        return cls.isPrimitive() ? cls == ClassUtil.m2190v(cls2) : cls2.isPrimitive() && cls2 == ClassUtil.m2190v(cls);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: j */
    public JacksonInject.a mo1786j(AnnotatedMember annotatedMember) {
        String name;
        JacksonInject jacksonInject = (JacksonInject) annotatedMember.mo1818b(JacksonInject.class);
        if (jacksonInject == null) {
            return null;
        }
        JacksonInject.a aVarM1593a = JacksonInject.a.m1593a(jacksonInject.value(), jacksonInject.useInput().m1613f());
        if (aVarM1593a._id != null) {
            return aVarM1593a;
        }
        if (annotatedMember instanceof AnnotatedMethod) {
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
            name = annotatedMethod.m1905o() == 0 ? annotatedMember.mo1820d().getName() : annotatedMethod.m1906p(0).getName();
        } else {
            name = annotatedMember.mo1820d().getName();
        }
        return name.equals(aVarM1593a._id) ? aVarM1593a : new JacksonInject.a(name, aVarM1593a._useInput);
    }

    /* JADX INFO: renamed from: j0 */
    public PropertyName m1936j0(String str, String str2) {
        return str.isEmpty() ? PropertyName.f5029j : (str2 == null || str2.isEmpty()) ? PropertyName.m2227a(str) : PropertyName.m2228b(str, str2);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    @Deprecated
    /* JADX INFO: renamed from: k */
    public Object mo1787k(AnnotatedMember annotatedMember) {
        JacksonInject.a aVarMo1786j = mo1786j(annotatedMember);
        if (aVarMo1786j == null) {
            return null;
        }
        return aVarMo1786j._id;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: l */
    public Object mo1788l(Annotated annotated) {
        Class<? extends JsonSerializer> clsKeyUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class);
        if (jsonSerialize == null || (clsKeyUsing = jsonSerialize.keyUsing()) == JsonSerializer.a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: m */
    public Boolean mo1789m(Annotated annotated) {
        JsonMerge jsonMerge = (JsonMerge) annotated.mo1818b(JsonMerge.class);
        if (jsonMerge == null) {
            return null;
        }
        return jsonMerge.value().m1613f();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: n */
    public PropertyName mo1790n(Annotated annotated) {
        boolean z2;
        JsonSetter jsonSetter = (JsonSetter) annotated.mo1818b(JsonSetter.class);
        if (jsonSetter != null) {
            String strValue = jsonSetter.value();
            if (!strValue.isEmpty()) {
                return PropertyName.m2227a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        JsonProperty jsonProperty = (JsonProperty) annotated.mo1818b(JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.m2228b(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = f4758k;
            AnnotationMap annotationMap = ((AnnotatedMember) annotated).f4717k;
            if (!(annotationMap != null ? annotationMap.m1917b(clsArr) : false)) {
                return null;
            }
        }
        return PropertyName.f5029j;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: o */
    public PropertyName mo1791o(Annotated annotated) {
        boolean z2;
        JsonGetter jsonGetter = (JsonGetter) annotated.mo1818b(JsonGetter.class);
        if (jsonGetter != null) {
            String strValue = jsonGetter.value();
            if (!strValue.isEmpty()) {
                return PropertyName.m2227a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        JsonProperty jsonProperty = (JsonProperty) annotated.mo1818b(JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.m2228b(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = f4757j;
            AnnotationMap annotationMap = ((AnnotatedMember) annotated).f4717k;
            if (!(annotationMap != null ? annotationMap.m1917b(clsArr) : false)) {
                return null;
            }
        }
        return PropertyName.f5029j;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: p */
    public Object mo1792p(AnnotatedClass annotatedClass) {
        JsonNaming jsonNaming = (JsonNaming) annotatedClass.mo1818b(JsonNaming.class);
        if (jsonNaming == null) {
            return null;
        }
        return jsonNaming.value();
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: q */
    public Object mo1793q(Annotated annotated) {
        Class<? extends JsonSerializer> clsNullsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class);
        if (jsonSerialize == null || (clsNullsUsing = jsonSerialize.nullsUsing()) == JsonSerializer.a.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: r */
    public ObjectIdInfo mo1794r(Annotated annotated) {
        JsonIdentityInfo jsonIdentityInfo = (JsonIdentityInfo) annotated.mo1818b(JsonIdentityInfo.class);
        if (jsonIdentityInfo == null || jsonIdentityInfo.generator() == ObjectIdGenerators2.class) {
            return null;
        }
        return new ObjectIdInfo(PropertyName.m2227a(jsonIdentityInfo.property()), jsonIdentityInfo.scope(), jsonIdentityInfo.generator(), false, jsonIdentityInfo.resolver());
    }

    public Object readResolve() {
        if (this.f4760m == null) {
            this.f4760m = new LRUMap<>(48, 48);
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: s */
    public ObjectIdInfo mo1795s(Annotated annotated, ObjectIdInfo objectIdInfo) {
        JsonIdentityReference jsonIdentityReference = (JsonIdentityReference) annotated.mo1818b(JsonIdentityReference.class);
        if (jsonIdentityReference == null) {
            return objectIdInfo;
        }
        if (objectIdInfo == null) {
            objectIdInfo = ObjectIdInfo.f4627a;
        }
        boolean zAlwaysAsId = jsonIdentityReference.alwaysAsId();
        return objectIdInfo.f4632f == zAlwaysAsId ? objectIdInfo : new ObjectIdInfo(objectIdInfo.f4628b, objectIdInfo.f4631e, objectIdInfo.f4629c, zAlwaysAsId, objectIdInfo.f4630d);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: t */
    public JsonProperty.a mo1796t(Annotated annotated) {
        JsonProperty jsonProperty = (JsonProperty) annotated.mo1818b(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.access();
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: u */
    public TypeResolverBuilder<?> mo1797u(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.mo2099k() != null) {
            return m1934h0(mapperConfig, annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + javaType + ")");
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: v */
    public String mo1798v(Annotated annotated) {
        JsonProperty jsonProperty = (JsonProperty) annotated.mo1818b(JsonProperty.class);
        if (jsonProperty == null) {
            return null;
        }
        String strDefaultValue = jsonProperty.defaultValue();
        if (strDefaultValue.isEmpty()) {
            return null;
        }
        return strDefaultValue;
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: w */
    public String mo1799w(Annotated annotated) {
        JsonPropertyDescription jsonPropertyDescription = (JsonPropertyDescription) annotated.mo1818b(JsonPropertyDescription.class);
        if (jsonPropertyDescription == null) {
            return null;
        }
        return jsonPropertyDescription.value();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet] */
    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: x */
    public JsonIgnoreProperties.a mo1800x(MapperConfig<?> mapperConfig, Annotated annotated) {
        ?? EmptySet;
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) annotated.mo1818b(JsonIgnoreProperties.class);
        if (jsonIgnoreProperties == null) {
            return JsonIgnoreProperties.a.f4427j;
        }
        JsonIgnoreProperties.a aVar = JsonIgnoreProperties.a.f4427j;
        String[] strArrValue = jsonIgnoreProperties.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return JsonIgnoreProperties.a.m1616c(EmptySet, jsonIgnoreProperties.ignoreUnknown(), jsonIgnoreProperties.allowGetters(), jsonIgnoreProperties.allowSetters(), false);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    @Deprecated
    /* JADX INFO: renamed from: y */
    public JsonIgnoreProperties.a mo1801y(Annotated annotated) {
        return mo1800x(null, annotated);
    }

    @Override // p007b.p195g.p196a.p205c.AnnotationIntrospector
    /* JADX INFO: renamed from: z */
    public JsonInclude.b mo1802z(Annotated annotated) {
        JsonInclude.b bVar;
        JsonSerialize jsonSerialize;
        JsonInclude.b bVarM1619b;
        JsonInclude.a aVar = JsonInclude.a.USE_DEFAULTS;
        JsonInclude jsonInclude = (JsonInclude) annotated.mo1818b(JsonInclude.class);
        if (jsonInclude == null) {
            JsonInclude.b bVar2 = JsonInclude.b.f4436j;
            bVar = JsonInclude.b.f4436j;
        } else {
            JsonInclude.b bVar3 = JsonInclude.b.f4436j;
            JsonInclude.a aVarValue = jsonInclude.value();
            JsonInclude.a aVarContent = jsonInclude.content();
            if (aVarValue == aVar && aVarContent == aVar) {
                bVar = JsonInclude.b.f4436j;
            } else {
                Class<?> clsValueFilter = jsonInclude.valueFilter();
                if (clsValueFilter == Void.class) {
                    clsValueFilter = null;
                }
                Class<?> clsContentFilter = jsonInclude.contentFilter();
                bVar = new JsonInclude.b(aVarValue, aVarContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
            }
        }
        if (bVar._valueInclusion != aVar || (jsonSerialize = (JsonSerialize) annotated.mo1818b(JsonSerialize.class)) == null) {
            return bVar;
        }
        int iOrdinal = jsonSerialize.include().ordinal();
        if (iOrdinal == 0) {
            bVarM1619b = bVar.m1619b(JsonInclude.a.ALWAYS);
        } else if (iOrdinal == 1) {
            bVarM1619b = bVar.m1619b(JsonInclude.a.NON_NULL);
        } else if (iOrdinal == 2) {
            bVarM1619b = bVar.m1619b(JsonInclude.a.NON_DEFAULT);
        } else {
            if (iOrdinal != 3) {
                return bVar;
            }
            bVarM1619b = bVar.m1619b(JsonInclude.a.NON_EMPTY);
        }
        return bVarM1619b;
    }
}
