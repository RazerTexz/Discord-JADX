package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p212e0.PolymorphicTypeValidator;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;

/* compiled from: MinimalClassNameIdResolver.java */
/* renamed from: b.g.a.c.e0.h.h, reason: use source file name */
/* loaded from: classes3.dex */
public class MinimalClassNameIdResolver extends ClassNameIdResolver {

    /* renamed from: c */
    public final String f4773c;

    public MinimalClassNameIdResolver(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory, polymorphicTypeValidator);
        String name = javaType._class.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.f4773c = ".";
        } else {
            this.f4773c = name.substring(0, iLastIndexOf + 1);
            name.substring(0, iLastIndexOf);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.ClassNameIdResolver, p007b.p195g.p196a.p205c.p212e0.TypeIdResolver
    /* renamed from: a */
    public String mo1946a(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.f4773c) ? name.substring(this.f4773c.length() - 1) : name;
    }
}
