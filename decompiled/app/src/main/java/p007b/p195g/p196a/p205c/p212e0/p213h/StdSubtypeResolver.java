package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClassResolver;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.NamedType;
import p007b.p195g.p196a.p205c.p212e0.SubtypeResolver;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* compiled from: StdSubtypeResolver.java */
/* renamed from: b.g.a.c.e0.h.i, reason: use source file name */
/* loaded from: classes3.dex */
public class StdSubtypeResolver extends SubtypeResolver implements Serializable {
    private static final long serialVersionUID = 1;
    public LinkedHashSet<NamedType> _registeredSubtypes;

    @Override // p007b.p195g.p196a.p205c.p212e0.SubtypeResolver
    /* renamed from: a */
    public Collection<NamedType> mo1945a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        List<NamedType> listMo1758N;
        AnnotationIntrospector annotationIntrospectorM2267e = mapperConfig.m2267e();
        Class<?> clsMo1820d = javaType == null ? annotatedMember.mo1820d() : javaType._class;
        HashMap<NamedType, NamedType> map = new HashMap<>();
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            for (NamedType namedType : linkedHashSet) {
                if (clsMo1820d.isAssignableFrom(namedType._class)) {
                    m1965b(AnnotatedClassResolver.m1879h(mapperConfig, namedType._class), namedType, mapperConfig, annotationIntrospectorM2267e, map);
                }
            }
        }
        if (annotatedMember != null && (listMo1758N = annotationIntrospectorM2267e.mo1758N(annotatedMember)) != null) {
            for (NamedType namedType2 : listMo1758N) {
                m1965b(AnnotatedClassResolver.m1879h(mapperConfig, namedType2._class), namedType2, mapperConfig, annotationIntrospectorM2267e, map);
            }
        }
        m1965b(AnnotatedClassResolver.m1879h(mapperConfig, clsMo1820d), new NamedType(clsMo1820d, null), mapperConfig, annotationIntrospectorM2267e, map);
        return new ArrayList(map.values());
    }

    /* renamed from: b */
    public void m1965b(AnnotatedClass annotatedClass, NamedType namedType, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, HashMap<NamedType, NamedType> map) {
        String strMo1759O;
        if (!namedType.m1944a() && (strMo1759O = annotationIntrospector.mo1759O(annotatedClass)) != null) {
            namedType = new NamedType(namedType._class, strMo1759O);
        }
        NamedType namedType2 = new NamedType(namedType._class, null);
        if (map.containsKey(namedType2)) {
            if (!namedType.m1944a() || map.get(namedType2).m1944a()) {
                return;
            }
            map.put(namedType2, namedType);
            return;
        }
        map.put(namedType2, namedType);
        List<NamedType> listMo1758N = annotationIntrospector.mo1758N(annotatedClass);
        if (listMo1758N == null || listMo1758N.isEmpty()) {
            return;
        }
        for (NamedType namedType3 : listMo1758N) {
            m1965b(AnnotatedClassResolver.m1879h(mapperConfig, namedType3._class), namedType3, mapperConfig, annotationIntrospector, map);
        }
    }
}
