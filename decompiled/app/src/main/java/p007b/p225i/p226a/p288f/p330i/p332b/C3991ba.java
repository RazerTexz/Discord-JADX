package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3657f9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3663g1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3677h1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3691i1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3730l0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3739l9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3769o0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3899y0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3912z0;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* renamed from: b.i.a.f.i.b.ba */
/* loaded from: classes3.dex */
public final class C3991ba extends AbstractC4074i9 {

    /* renamed from: d */
    public String f10574d;

    /* renamed from: e */
    public Set<Integer> f10575e;

    /* renamed from: f */
    public Map<Integer, C4015da> f10576f;

    /* renamed from: g */
    public Long f10577g;

    /* renamed from: h */
    public Long f10578h;

    public C3991ba(C4097k9 c4097k9) {
        super(c4097k9);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* renamed from: p */
    public final boolean mo5515p() {
        return false;
    }

    /* renamed from: s */
    public final C4015da m5516s(int i) {
        if (this.f10576f.containsKey(Integer.valueOf(i))) {
            return this.f10576f.get(Integer.valueOf(i));
        }
        C4015da c4015da = new C4015da(this, this.f10574d, null);
        this.f10576f.put(Integer.valueOf(i), c4015da);
        return c4015da;
    }

    /* JADX WARN: Code restructure failed: missing block: B:361:0x0903, code lost:
    
        r0 = mo5726g().f11144i;
        r1 = p007b.p225i.p226a.p288f.p330i.p332b.C4157q3.m5788s(r62.f10574d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0913, code lost:
    
        if (r8.m5147v() == false) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0915, code lost:
    
        r7 = java.lang.Integer.valueOf(r8.m5148w());
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x091e, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x091f, code lost:
    
        r0.m5862c("Invalid property filter ID. appId, id", r1, java.lang.String.valueOf(r7));
        r9 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x027b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0959  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x09e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bb A[Catch: SQLiteException -> 0x022c, all -> 0x09dc, TryCatch #15 {all -> 0x09dc, blocks: (B:67:0x01b5, B:69:0x01bb, B:71:0x01c1, B:73:0x01cd, B:76:0x01db, B:77:0x01e1, B:78:0x01e9, B:79:0x01fb, B:82:0x021b, B:81:0x0206, B:92:0x0234, B:94:0x0249, B:96:0x0255), top: B:406:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01db A[Catch: SQLiteException -> 0x022c, all -> 0x09dc, TRY_ENTER, TryCatch #15 {all -> 0x09dc, blocks: (B:67:0x01b5, B:69:0x01bb, B:71:0x01c1, B:73:0x01cd, B:76:0x01db, B:77:0x01e1, B:78:0x01e9, B:79:0x01fb, B:82:0x021b, B:81:0x0206, B:92:0x0234, B:94:0x0249, B:96:0x0255), top: B:406:0x019c }] */
    /* JADX WARN: Type inference failed for: r4v44, types: [androidx.collection.ArrayMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v47, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @WorkerThread
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<C3899y0> m5517t(String str, List<C3579a1> list, List<C3691i1> list2, Long l, Long l2) throws Throwable {
        int i;
        int i2;
        boolean z2;
        Cursor cursor;
        Object obj;
        Map map;
        Object obj2;
        C4040g c4040gM5686q;
        String str2;
        ?? r7;
        Cursor cursorQuery;
        Map mapEmptyMap;
        Map map2;
        String str3;
        Iterator<Integer> it;
        ArrayMap arrayMap;
        String str4;
        Integer numValueOf;
        C4098l c4098l;
        C4003ca c4003ca;
        Iterator<Integer> it2;
        ArrayMap arrayMap2;
        Iterator<C3579a1> it3;
        String str5;
        Map map3;
        Iterator it4;
        List<C3730l0> list3;
        boolean z3;
        Map map4;
        ?? r72;
        Cursor cursorRawQuery;
        Iterator it5;
        Map map5;
        Iterator it6;
        ArrayMap arrayMap3;
        Cursor cursor2;
        Cursor cursorQuery2;
        AnimatableValueParser.m583w(str);
        Objects.requireNonNull(list, "null reference");
        Objects.requireNonNull(list2, "null reference");
        this.f10574d = str;
        this.f10575e = new HashSet();
        this.f10576f = new ArrayMap();
        this.f10577g = l;
        this.f10578h = l2;
        Iterator<C3579a1> it7 = list.iterator();
        while (true) {
            i = 1;
            i2 = 0;
            if (!it7.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it7.next().m4533F())) {
                z2 = true;
                break;
            }
        }
        boolean z4 = C3657f9.m4881b() && this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11066c0);
        boolean z5 = C3657f9.m4881b() && this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11064b0);
        if (z2) {
            C4040g c4040gM5686q2 = m5686q();
            String str6 = this.f10574d;
            c4040gM5686q2.m5684n();
            c4040gM5686q2.mo5848b();
            AnimatableValueParser.m583w(str6);
            ContentValues contentValues = new ContentValues();
            ?? r5 = "current_session_count";
            contentValues.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseM5640t = c4040gM5686q2.m5640t();
                r5 = "events";
                sQLiteDatabaseM5640t.update("events", contentValues, "app_id = ?", new String[]{str6});
                obj = sQLiteDatabaseM5640t;
                cursor = "events";
            } catch (SQLiteException e) {
                c4040gM5686q2.mo5726g().f11141f.m5862c("Error resetting session-scoped event counts. appId", C4157q3.m5788s(str6), e);
                obj = "Error resetting session-scoped event counts. appId";
                cursor = r5;
            }
        }
        Map mapEmptyMap2 = Collections.emptyMap();
        Object obj3 = obj;
        obj3 = obj;
        if (z5 && z4) {
            C4040g c4040gM5686q3 = m5686q();
            String str7 = this.f10574d;
            Objects.requireNonNull(c4040gM5686q3);
            AnimatableValueParser.m583w(str7);
            ?? arrayMap4 = new ArrayMap();
            try {
                try {
                    cursorQuery2 = c4040gM5686q3.m5640t().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str7}, null, null, null);
                    try {
                    } catch (SQLiteException e2) {
                        e = e2;
                        c4040gM5686q3.mo5726g().f11141f.m5862c("Database error querying filters. appId", C4157q3.m5788s(str7), e);
                        mapEmptyMap2 = Collections.emptyMap();
                        obj3 = "Database error querying filters. appId";
                        if (cursorQuery2 != null) {
                            cursorQuery2.close();
                            obj3 = "Database error querying filters. appId";
                        }
                        map = mapEmptyMap2;
                        obj2 = obj3;
                        c4040gM5686q = m5686q();
                        str2 = this.f10574d;
                        c4040gM5686q.m5684n();
                        c4040gM5686q.mo5848b();
                        AnimatableValueParser.m583w(str2);
                        try {
                            cursorQuery = c4040gM5686q.m5640t().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
                            try {
                                if (!cursorQuery.moveToFirst()) {
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                c4040gM5686q.mo5726g().f11141f.m5862c("Database error querying filter results. appId", C4157q3.m5788s(str2), e);
                                if (!C3739l9.m5058b() || !c4040gM5686q.f11202a.f11260h.m5532u(str2, C4142p.f11031F0)) {
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    map2 = null;
                                    if (C3739l9.m5058b()) {
                                    }
                                    String str8 = "Skipping failed audience ID";
                                    if (!list.isEmpty()) {
                                    }
                                    if (!list2.isEmpty()) {
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    Set<Integer> setKeySet = this.f10576f.keySet();
                                    setKeySet.removeAll(this.f10575e);
                                    it = setKeySet.iterator();
                                    while (it.hasNext()) {
                                    }
                                    return arrayList;
                                }
                                mapEmptyMap = Collections.emptyMap();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = mapEmptyMap;
                                if (C3739l9.m5058b()) {
                                }
                                String str82 = "Skipping failed audience ID";
                                if (!list.isEmpty()) {
                                }
                                if (!list2.isEmpty()) {
                                }
                                ArrayList arrayList2 = new ArrayList();
                                Set<Integer> setKeySet2 = this.f10576f.keySet();
                                setKeySet2.removeAll(this.f10575e);
                                it = setKeySet2.iterator();
                                while (it.hasNext()) {
                                }
                                return arrayList2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            r7 = obj2;
                            if (r7 != null) {
                                r7.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursorQuery2 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = null;
                if (cursor2 != null) {
                }
                throw th;
            }
            if (cursorQuery2.moveToFirst()) {
                while (true) {
                    try {
                        C3730l0 c3730l0 = (C3730l0) ((AbstractC3851u4) ((C3730l0.a) C4163q9.m5832x(C3730l0.m5031I(), cursorQuery2.getBlob(1))).m5320p());
                        if (c3730l0.m5037C()) {
                            int i3 = cursorQuery2.getInt(i2);
                            List arrayList3 = (List) arrayMap4.get(Integer.valueOf(i3));
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                                arrayMap4.put(Integer.valueOf(i3), arrayList3);
                            }
                            arrayList3.add(c3730l0);
                        }
                    } catch (IOException e5) {
                        c4040gM5686q3.mo5726g().f11141f.m5862c("Failed to merge filter. appId", C4157q3.m5788s(str7), e5);
                    }
                    if (!cursorQuery2.moveToNext()) {
                        break;
                    }
                    i2 = 0;
                }
                cursorQuery2.close();
                map = arrayMap4;
                obj2 = arrayMap4;
            } else {
                mapEmptyMap2 = Collections.emptyMap();
                cursorQuery2.close();
                obj3 = arrayMap4;
                map = mapEmptyMap2;
                obj2 = obj3;
            }
        } else {
            map = mapEmptyMap2;
            obj2 = obj3;
        }
        c4040gM5686q = m5686q();
        str2 = this.f10574d;
        c4040gM5686q.m5684n();
        c4040gM5686q.mo5848b();
        AnimatableValueParser.m583w(str2);
        try {
            cursorQuery = c4040gM5686q.m5640t().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
        } catch (SQLiteException e6) {
            e = e6;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
            r7 = null;
            if (r7 != null) {
            }
            throw th;
        }
        if (!cursorQuery.moveToFirst()) {
            ArrayMap arrayMap5 = new ArrayMap();
            int i4 = 0;
            while (true) {
                int i5 = cursorQuery.getInt(i4);
                try {
                    arrayMap5.put(Integer.valueOf(i5), (C3663g1) ((AbstractC3851u4) ((C3663g1.a) C4163q9.m5832x(C3663g1.m4893M(), cursorQuery.getBlob(i))).m5320p()));
                    arrayMap3 = arrayMap5;
                } catch (IOException e7) {
                    arrayMap3 = arrayMap5;
                    c4040gM5686q.mo5726g().f11141f.m5863d("Failed to merge filter results. appId, audienceId, error", C4157q3.m5788s(str2), Integer.valueOf(i5), e7);
                }
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                arrayMap5 = arrayMap3;
                i4 = 0;
                i = 1;
            }
            cursorQuery.close();
            map2 = arrayMap3;
            if (C3739l9.m5058b()) {
            }
            String str822 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            if (!list2.isEmpty()) {
            }
            ArrayList arrayList22 = new ArrayList();
            Set<Integer> setKeySet22 = this.f10576f.keySet();
            setKeySet22.removeAll(this.f10575e);
            it = setKeySet22.iterator();
            while (it.hasNext()) {
            }
            return arrayList22;
        }
        if (C3739l9.m5058b() && c4040gM5686q.f11202a.f11260h.m5532u(str2, C4142p.f11031F0)) {
            mapEmptyMap = Collections.emptyMap();
            cursorQuery.close();
            map2 = mapEmptyMap;
            str3 = C3739l9.m5058b() ? "audience_id" : "audience_id";
            String str8222 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            if (!list2.isEmpty()) {
            }
            ArrayList arrayList222 = new ArrayList();
            Set<Integer> setKeySet222 = this.f10576f.keySet();
            setKeySet222.removeAll(this.f10575e);
            it = setKeySet222.iterator();
            while (it.hasNext()) {
            }
            return arrayList222;
        }
        cursorQuery.close();
        map2 = null;
        if (((C3739l9.m5058b() && this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11031F0)) || map2 != null) && !map2.isEmpty()) {
            HashSet hashSet = new HashSet(map2.keySet());
            if (z2) {
                String str9 = this.f10574d;
                AnimatableValueParser.m583w(str9);
                ArrayMap arrayMap6 = new ArrayMap();
                if (map2.isEmpty()) {
                    str5 = "audience_id";
                } else {
                    C4040g c4040gM5686q4 = m5686q();
                    c4040gM5686q4.m5684n();
                    c4040gM5686q4.mo5848b();
                    AnimatableValueParser.m583w(str9);
                    Map arrayMap7 = new ArrayMap();
                    SQLiteDatabase sQLiteDatabaseM5640t2 = c4040gM5686q4.m5640t();
                    try {
                        str5 = "audience_id";
                    } catch (Throwable th5) {
                        th = th5;
                        r72 = sQLiteDatabaseM5640t2;
                    }
                    try {
                        cursorRawQuery = sQLiteDatabaseM5640t2.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str9, str9});
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                do {
                                    int i6 = cursorRawQuery.getInt(0);
                                    List arrayList4 = (List) arrayMap7.get(Integer.valueOf(i6));
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        arrayMap7.put(Integer.valueOf(i6), arrayList4);
                                    }
                                    try {
                                        arrayList4.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        c4040gM5686q4.mo5726g().f11141f.m5862c("Database error querying scoped filters. appId", C4157q3.m5788s(str9), e);
                                        if (C3739l9.m5058b() && c4040gM5686q4.f11202a.f11260h.m5532u(str9, C4142p.f11031F0)) {
                                            arrayMap7 = Collections.emptyMap();
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                        } else {
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            arrayMap7 = null;
                                        }
                                        it5 = map2.keySet().iterator();
                                        while (it5.hasNext()) {
                                        }
                                        map3 = arrayMap6;
                                        it4 = hashSet.iterator();
                                        while (it4.hasNext()) {
                                        }
                                        str3 = str5;
                                        String str82222 = "Skipping failed audience ID";
                                        if (!list.isEmpty()) {
                                        }
                                        if (!list2.isEmpty()) {
                                        }
                                        ArrayList arrayList2222 = new ArrayList();
                                        Set<Integer> setKeySet2222 = this.f10576f.keySet();
                                        setKeySet2222.removeAll(this.f10575e);
                                        it = setKeySet2222.iterator();
                                        while (it.hasNext()) {
                                        }
                                        return arrayList2222;
                                    }
                                } while (cursorRawQuery.moveToNext());
                                cursorRawQuery.close();
                            } else {
                                arrayMap7 = Collections.emptyMap();
                                cursorRawQuery.close();
                            }
                        } catch (SQLiteException e9) {
                            e = e9;
                        }
                    } catch (SQLiteException e10) {
                        e = e10;
                        cursorRawQuery = null;
                    } catch (Throwable th6) {
                        th = th6;
                        r72 = 0;
                        if (r72 != 0) {
                            r72.close();
                        }
                        throw th;
                    }
                    it5 = map2.keySet().iterator();
                    while (it5.hasNext()) {
                        int iIntValue = ((Integer) it5.next()).intValue();
                        C3663g1 c3663g1 = (C3663g1) map2.get(Integer.valueOf(iIntValue));
                        List<Integer> list4 = (List) arrayMap7.get(Integer.valueOf(iIntValue));
                        if (list4 == null || list4.isEmpty()) {
                            map5 = arrayMap7;
                            it6 = it5;
                            arrayMap6.put(Integer.valueOf(iIntValue), c3663g1);
                            it5 = it6;
                            arrayMap7 = map5;
                        } else {
                            List<Long> listM5833C = m5683m().m5833C(c3663g1.m4900E(), list4);
                            if (!listM5833C.isEmpty()) {
                                C3663g1.a aVarM5315t = c3663g1.m5315t();
                                map5 = arrayMap7;
                                if (aVarM5315t.f10348l) {
                                    aVarM5315t.m5318n();
                                    it6 = it5;
                                    aVarM5315t.f10348l = false;
                                } else {
                                    it6 = it5;
                                }
                                C3663g1.m4888B((C3663g1) aVarM5315t.f10347k);
                                if (aVarM5315t.f10348l) {
                                    aVarM5315t.m5318n();
                                    aVarM5315t.f10348l = false;
                                }
                                C3663g1.m4890D((C3663g1) aVarM5315t.f10347k, listM5833C);
                                List<Long> listM5833C2 = m5683m().m5833C(c3663g1.m4907v(), list4);
                                if (aVarM5315t.f10348l) {
                                    aVarM5315t.m5318n();
                                    aVarM5315t.f10348l = false;
                                }
                                C3663g1.m4896w((C3663g1) aVarM5315t.f10347k);
                                if (aVarM5315t.f10348l) {
                                    aVarM5315t.m5318n();
                                    aVarM5315t.f10348l = false;
                                }
                                C3663g1.m4898y((C3663g1) aVarM5315t.f10347k, listM5833C2);
                                for (int i7 = 0; i7 < c3663g1.m4903J(); i7++) {
                                    if (list4.contains(Integer.valueOf(c3663g1.m4906u(i7).m5394x()))) {
                                        if (aVarM5315t.f10348l) {
                                            aVarM5315t.m5318n();
                                            aVarM5315t.f10348l = false;
                                        }
                                        C3663g1.m4897x((C3663g1) aVarM5315t.f10347k, i7);
                                    }
                                }
                                for (int i8 = 0; i8 < c3663g1.m4905L(); i8++) {
                                    if (list4.contains(Integer.valueOf(c3663g1.m4899A(i8).m4931y()))) {
                                        if (aVarM5315t.f10348l) {
                                            aVarM5315t.m5318n();
                                            aVarM5315t.f10348l = false;
                                        }
                                        C3663g1.m4889C((C3663g1) aVarM5315t.f10347k, i8);
                                    }
                                }
                                arrayMap6.put(Integer.valueOf(iIntValue), (C3663g1) ((AbstractC3851u4) aVarM5315t.m5320p()));
                                it5 = it6;
                                arrayMap7 = map5;
                            }
                        }
                    }
                }
                map3 = arrayMap6;
            } else {
                str5 = "audience_id";
                map3 = map2;
            }
            it4 = hashSet.iterator();
            while (it4.hasNext()) {
                int iIntValue2 = ((Integer) it4.next()).intValue();
                C3663g1 c3663g12 = (C3663g1) map3.get(Integer.valueOf(iIntValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap8 = new ArrayMap();
                if (c3663g12 != null && c3663g12.m4903J() != 0) {
                    for (C3912z0 c3912z0 : c3663g12.m4902I()) {
                        if (c3912z0.m5393w()) {
                            arrayMap8.put(Integer.valueOf(c3912z0.m5394x()), c3912z0.m5395y() ? Long.valueOf(c3912z0.m5396z()) : null);
                        }
                    }
                }
                ArrayMap arrayMap9 = new ArrayMap();
                if (c3663g12 != null && c3663g12.m4905L() != 0) {
                    for (C3677h1 c3677h1 : c3663g12.m4904K()) {
                        if (!c3677h1.m4930x() || c3677h1.m4928A() <= 0) {
                            map4 = map3;
                        } else {
                            map4 = map3;
                            arrayMap9.put(Integer.valueOf(c3677h1.m4931y()), Long.valueOf(c3677h1.m4929u(c3677h1.m4928A() - 1)));
                        }
                        map3 = map4;
                    }
                }
                Map map6 = map3;
                if (c3663g12 != null) {
                    for (int i9 = 0; i9 < (c3663g12.m4908z() << 6); i9++) {
                        if (C4163q9.m5828Q(c3663g12.m4907v(), i9)) {
                            mo5726g().f11149n.m5862c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i9));
                            bitSet2.set(i9);
                            if (C4163q9.m5828Q(c3663g12.m4900E(), i9)) {
                                bitSet.set(i9);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        }
                        if (!z3) {
                            arrayMap8.remove(Integer.valueOf(i9));
                        }
                    }
                }
                C3663g1 c3663g13 = (C3663g1) map2.get(Integer.valueOf(iIntValue2));
                if (z5 && z4 && (list3 = (List) map.get(Integer.valueOf(iIntValue2))) != null && this.f10578h != null && this.f10577g != null) {
                    for (C3730l0 c3730l02 : list3) {
                        int iM5045y = c3730l02.m5045y();
                        long jLongValue = this.f10578h.longValue() / 1000;
                        if (c3730l02.m5040F()) {
                            jLongValue = this.f10577g.longValue() / 1000;
                        }
                        if (arrayMap8.containsKey(Integer.valueOf(iM5045y))) {
                            arrayMap8.put(Integer.valueOf(iM5045y), Long.valueOf(jLongValue));
                        }
                        if (arrayMap9.containsKey(Integer.valueOf(iM5045y))) {
                            arrayMap9.put(Integer.valueOf(iM5045y), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.f10576f.put(Integer.valueOf(iIntValue2), new C4015da(this, this.f10574d, c3663g13, bitSet, bitSet2, arrayMap8, arrayMap9, null));
                str5 = str5;
                map = map;
                map3 = map6;
            }
            str3 = str5;
        }
        String str822222 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            C4003ca c4003ca2 = new C4003ca(this, null);
            ArrayMap arrayMap10 = new ArrayMap();
            Iterator<C3579a1> it8 = list.iterator();
            while (it8.hasNext()) {
                C3579a1 next = it8.next();
                C3579a1 c3579a1M5561a = c4003ca2.m5561a(this.f10574d, next);
                if (c3579a1M5561a != null) {
                    C4040g c4040gM5686q5 = m5686q();
                    String str10 = this.f10574d;
                    String strM4533F = c3579a1M5561a.m4533F();
                    C4098l c4098lM5646z = c4040gM5686q5.m5646z(str10, next.m4533F());
                    if (c4098lM5646z == null) {
                        c4040gM5686q5.mo5726g().f11144i.m5862c("Event aggregate wasn't created during raw event logging. appId, event", C4157q3.m5788s(str10), c4040gM5686q5.m5865d().m5766u(strM4533F));
                        c4098l = new C4098l(str10, next.m4533F(), 1L, 1L, 1L, next.m4535H(), 0L, null, null, null, null);
                    } else {
                        c4098l = new C4098l(c4098lM5646z.f10926a, c4098lM5646z.f10927b, c4098lM5646z.f10928c + 1, c4098lM5646z.f10929d + 1, c4098lM5646z.f10930e + 1, c4098lM5646z.f10931f, c4098lM5646z.f10932g, c4098lM5646z.f10933h, c4098lM5646z.f10934i, c4098lM5646z.f10935j, c4098lM5646z.f10936k);
                    }
                    m5686q().m5610H(c4098l);
                    long j = c4098l.f10928c;
                    String strM4533F2 = c3579a1M5561a.m4533F();
                    Map<Integer, List<C3730l0>> mapM5631c0 = (Map) arrayMap10.get(strM4533F2);
                    if (mapM5631c0 == null) {
                        mapM5631c0 = m5686q().m5631c0(this.f10574d, strM4533F2);
                        if (C3739l9.m5058b()) {
                            c4003ca = c4003ca2;
                            if (!this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11031F0)) {
                            }
                            arrayMap10.put(strM4533F2, mapM5631c0);
                        } else {
                            c4003ca = c4003ca2;
                        }
                        if (mapM5631c0 == null) {
                            mapM5631c0 = new ArrayMap();
                        }
                        arrayMap10.put(strM4533F2, mapM5631c0);
                    } else {
                        c4003ca = c4003ca2;
                    }
                    Iterator<Integer> it9 = mapM5631c0.keySet().iterator();
                    while (it9.hasNext()) {
                        int iIntValue3 = it9.next().intValue();
                        if (this.f10575e.contains(Integer.valueOf(iIntValue3))) {
                            mo5726g().f11149n.m5861b("Skipping failed audience ID", Integer.valueOf(iIntValue3));
                        } else {
                            Iterator<C3730l0> it10 = mapM5631c0.get(Integer.valueOf(iIntValue3)).iterator();
                            boolean zM5602i = true;
                            while (true) {
                                if (!it10.hasNext()) {
                                    it2 = it9;
                                    arrayMap2 = arrayMap10;
                                    it3 = it8;
                                    break;
                                }
                                C3730l0 next2 = it10.next();
                                it2 = it9;
                                arrayMap2 = arrayMap10;
                                C4039fa c4039fa = new C4039fa(this, this.f10574d, iIntValue3, next2);
                                it3 = it8;
                                zM5602i = c4039fa.m5602i(this.f10577g, this.f10578h, c3579a1M5561a, j, c4098l, m5518u(iIntValue3, next2.m5045y()));
                                if (!zM5602i) {
                                    this.f10575e.add(Integer.valueOf(iIntValue3));
                                    break;
                                }
                                m5516s(iIntValue3).m5587b(c4039fa);
                                it9 = it2;
                                arrayMap10 = arrayMap2;
                                it8 = it3;
                            }
                            if (!zM5602i) {
                                this.f10575e.add(Integer.valueOf(iIntValue3));
                            }
                            it9 = it2;
                            arrayMap10 = arrayMap2;
                            it8 = it3;
                        }
                    }
                    c4003ca2 = c4003ca;
                }
            }
        }
        if (!list2.isEmpty()) {
            ArrayMap arrayMap11 = new ArrayMap();
            for (C3691i1 c3691i1 : list2) {
                String strM4949D = c3691i1.m4949D();
                Map<Integer, List<C3769o0>> mapM5632d0 = (Map) arrayMap11.get(strM4949D);
                if (mapM5632d0 == null) {
                    mapM5632d0 = m5686q().m5632d0(this.f10574d, strM4949D);
                    if ((!C3739l9.m5058b() || !this.f11202a.f11260h.m5532u(this.f10574d, C4142p.f11031F0)) && mapM5632d0 == null) {
                        mapM5632d0 = new ArrayMap<>();
                    }
                    arrayMap11.put(strM4949D, mapM5632d0);
                }
                Iterator<Integer> it11 = mapM5632d0.keySet().iterator();
                while (true) {
                    if (it11.hasNext()) {
                        int iIntValue4 = it11.next().intValue();
                        if (this.f10575e.contains(Integer.valueOf(iIntValue4))) {
                            mo5726g().f11149n.m5861b(str822222, Integer.valueOf(iIntValue4));
                            break;
                        }
                        Iterator<C3769o0> it12 = mapM5632d0.get(Integer.valueOf(iIntValue4)).iterator();
                        boolean zM5662i = true;
                        while (true) {
                            if (!it12.hasNext()) {
                                arrayMap = arrayMap11;
                                str4 = str822222;
                                break;
                            }
                            C3769o0 next3 = it12.next();
                            if (mo5726g().m5800x(2)) {
                                C4179s3 c4179s3 = mo5726g().f11149n;
                                Integer numValueOf2 = Integer.valueOf(iIntValue4);
                                if (next3.m5147v()) {
                                    arrayMap = arrayMap11;
                                    numValueOf = Integer.valueOf(next3.m5148w());
                                } else {
                                    arrayMap = arrayMap11;
                                    numValueOf = null;
                                }
                                str4 = str822222;
                                c4179s3.m5863d("Evaluating filter. audience, filter, property", numValueOf2, numValueOf, m5865d().m5769y(next3.m5149x()));
                                mo5726g().f11149n.m5861b("Filter definition", m5683m().m5845y(next3));
                            } else {
                                arrayMap = arrayMap11;
                                str4 = str822222;
                            }
                            if (!next3.m5147v() || next3.m5148w() > 256) {
                                break;
                            }
                            C4063ha c4063ha = new C4063ha(this, this.f10574d, iIntValue4, next3);
                            zM5662i = c4063ha.m5662i(this.f10577g, this.f10578h, c3691i1, m5518u(iIntValue4, next3.m5148w()));
                            if (!zM5662i) {
                                this.f10575e.add(Integer.valueOf(iIntValue4));
                                break;
                            }
                            m5516s(iIntValue4).m5587b(c4063ha);
                            arrayMap11 = arrayMap;
                            str822222 = str4;
                        }
                        if (!zM5662i) {
                            this.f10575e.add(Integer.valueOf(iIntValue4));
                        }
                        arrayMap11 = arrayMap;
                        str822222 = str4;
                    }
                }
            }
        }
        ArrayList arrayList22222 = new ArrayList();
        Set<Integer> setKeySet22222 = this.f10576f.keySet();
        setKeySet22222.removeAll(this.f10575e);
        it = setKeySet22222.iterator();
        while (it.hasNext()) {
            int iIntValue5 = it.next().intValue();
            C3899y0 c3899y0M5586a = this.f10576f.get(Integer.valueOf(iIntValue5)).m5586a(iIntValue5);
            arrayList22222.add(c3899y0M5586a);
            C4040g c4040gM5686q6 = m5686q();
            String str11 = this.f10574d;
            C3663g1 c3663g1M5369A = c3899y0M5586a.m5369A();
            c4040gM5686q6.m5684n();
            c4040gM5686q6.mo5848b();
            AnimatableValueParser.m583w(str11);
            Objects.requireNonNull(c3663g1M5369A, "null reference");
            byte[] bArrM5052d = c3663g1M5369A.m5052d();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str11);
            contentValues2.put(str3, Integer.valueOf(iIntValue5));
            contentValues2.put("current_results", bArrM5052d);
            try {
            } catch (SQLiteException e11) {
                e = e11;
            }
            try {
                if (c4040gM5686q6.m5640t().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                    c4040gM5686q6.mo5726g().f11141f.m5861b("Failed to insert filter results (got -1). appId", C4157q3.m5788s(str11));
                }
            } catch (SQLiteException e12) {
                e = e12;
                c4040gM5686q6.mo5726g().f11141f.m5862c("Error storing filter results. appId", C4157q3.m5788s(str11), e);
            }
        }
        return arrayList22222;
    }

    /* renamed from: u */
    public final boolean m5518u(int i, int i2) {
        if (this.f10576f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f10576f.get(Integer.valueOf(i)).f10675d.get(i2);
    }
}
