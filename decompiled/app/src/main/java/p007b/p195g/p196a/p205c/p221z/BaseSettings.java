package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import p007b.p195g.p196a.p198b.Base64Variant;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.PropertyNamingStrategy;
import p007b.p195g.p196a.p205c.p210c0.AccessorNamingStrategy;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p212e0.PolymorphicTypeValidator;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;

/* JADX INFO: renamed from: b.g.a.c.z.a, reason: use source file name */
/* JADX INFO: compiled from: BaseSettings.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BaseSettings implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final TimeZone f5074j = TimeZone.getTimeZone("UTC");
    private static final long serialVersionUID = 1;
    public final AccessorNamingStrategy.a _accessorNaming;
    public final AnnotationIntrospector _annotationIntrospector;
    public final ClassIntrospector _classIntrospector;
    public final DateFormat _dateFormat;
    public final Base64Variant _defaultBase64;
    public final HandlerInstantiator _handlerInstantiator;
    public final Locale _locale;
    public final PropertyNamingStrategy _propertyNamingStrategy;
    public final TimeZone _timeZone;
    public final TypeFactory _typeFactory;
    public final TypeResolverBuilder<?> _typeResolverBuilder;
    public final PolymorphicTypeValidator _typeValidator;

    public BaseSettings(ClassIntrospector classIntrospector, AnnotationIntrospector annotationIntrospector, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, TypeResolverBuilder typeResolverBuilder, DateFormat dateFormat, Locale locale, TimeZone timeZone, Base64Variant base64Variant, PolymorphicTypeValidator polymorphicTypeValidator, AccessorNamingStrategy.a aVar) {
        this._classIntrospector = classIntrospector;
        this._annotationIntrospector = annotationIntrospector;
        this._propertyNamingStrategy = propertyNamingStrategy;
        this._typeFactory = typeFactory;
        this._typeResolverBuilder = typeResolverBuilder;
        this._dateFormat = dateFormat;
        this._locale = locale;
        this._timeZone = timeZone;
        this._defaultBase64 = base64Variant;
        this._typeValidator = polymorphicTypeValidator;
        this._accessorNaming = aVar;
    }
}
