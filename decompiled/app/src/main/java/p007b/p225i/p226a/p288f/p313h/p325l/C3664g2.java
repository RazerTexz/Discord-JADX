package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.h.l.g2 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3664g2 implements InterfaceC3622d2 {

    /* renamed from: a */
    public final C3608c2 f9964a;

    /* renamed from: b */
    public final String f9965b;

    public C3664g2(C3608c2 c3608c2, String str) {
        this.f9964a = c3608c2;
        this.f9965b = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        if (p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10344l == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10338f.isEmpty() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
    
        r6 = p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10345m;
        r10 = p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10338f;
        r2 = r2.query(p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10334b, null, null, r6, null);
        r3 = new java.util.TreeMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        if (r2 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
    
        if (r2.moveToNext() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
    
        r3.put(r2.getString(0), r2.getString(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        r10.putAll(r3);
        p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10344l = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c7, code lost:
    
        if (p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10338f.containsKey(r1) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        r1 = p007b.p225i.p226a.p288f.p313h.p325l.C3848u1.f10338f.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d1, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d3, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
    
        throw r1;
     */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3622d2
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4628a() {
        String str;
        C3608c2 c3608c2 = this.f9964a;
        String str2 = this.f9965b;
        ContentResolver contentResolver = c3608c2.f9872b.getContentResolver();
        Uri uri = C3848u1.f10333a;
        synchronized (C3848u1.class) {
            if (C3848u1.f10338f == null) {
                C3848u1.f10337e.set(false);
                C3848u1.f10338f = new HashMap<>();
                C3848u1.f10343k = new Object();
                C3848u1.f10344l = false;
                contentResolver.registerContentObserver(C3848u1.f10333a, true, new C3835t1());
            } else if (C3848u1.f10337e.getAndSet(false)) {
                C3848u1.f10338f.clear();
                C3848u1.f10339g.clear();
                C3848u1.f10340h.clear();
                C3848u1.f10341i.clear();
                C3848u1.f10342j.clear();
                C3848u1.f10343k = new Object();
                C3848u1.f10344l = false;
            }
            Object obj = C3848u1.f10343k;
            if (C3848u1.f10338f.containsKey(str2)) {
                String str3 = C3848u1.f10338f.get(str2);
                str = str3 != null ? str3 : null;
            } else {
                String[] strArr = C3848u1.f10345m;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        Cursor cursorQuery = contentResolver.query(C3848u1.f10333a, null, null, new String[]{str2}, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    String string = cursorQuery.getString(1);
                                    if (string != null && string.equals(null)) {
                                        string = null;
                                    }
                                    C3848u1.m5308a(obj, str2, string);
                                    str = string != null ? string : null;
                                } else {
                                    C3848u1.m5308a(obj, str2, null);
                                }
                            } finally {
                            }
                        } else if (cursorQuery != null) {
                        }
                    } else {
                        if (str2.startsWith(strArr[i])) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return str;
    }
}
