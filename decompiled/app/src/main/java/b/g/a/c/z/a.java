package b.g.a.c.z;

import b.g.a.c.c0.a;
import b.g.a.c.c0.t;
import b.g.a.c.u;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: BaseSettings.java */
/* loaded from: classes3.dex */
public final class a implements Serializable {
    public static final TimeZone j = TimeZone.getTimeZone("UTC");
    private static final long serialVersionUID = 1;
    public final a.AbstractC0083a _accessorNaming;
    public final b.g.a.c.b _annotationIntrospector;
    public final t _classIntrospector;
    public final DateFormat _dateFormat;
    public final b.g.a.b.a _defaultBase64;
    public final k _handlerInstantiator;
    public final Locale _locale;
    public final u _propertyNamingStrategy;
    public final TimeZone _timeZone;
    public final b.g.a.c.h0.n _typeFactory;
    public final b.g.a.c.e0.f<?> _typeResolverBuilder;
    public final b.g.a.c.e0.c _typeValidator;

    public a(t tVar, b.g.a.c.b bVar, u uVar, b.g.a.c.h0.n nVar, b.g.a.c.e0.f fVar, DateFormat dateFormat, Locale locale, TimeZone timeZone, b.g.a.b.a aVar, b.g.a.c.e0.c cVar, a.AbstractC0083a abstractC0083a) {
        this._classIntrospector = tVar;
        this._annotationIntrospector = bVar;
        this._propertyNamingStrategy = uVar;
        this._typeFactory = nVar;
        this._typeResolverBuilder = fVar;
        this._dateFormat = dateFormat;
        this._locale = locale;
        this._timeZone = timeZone;
        this._defaultBase64 = aVar;
        this._typeValidator = cVar;
        this._accessorNaming = abstractC0083a;
    }
}
