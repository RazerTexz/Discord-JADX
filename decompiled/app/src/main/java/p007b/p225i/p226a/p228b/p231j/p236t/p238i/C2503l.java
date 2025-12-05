package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.Cursor;
import java.util.ArrayList;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t;

/* compiled from: SQLiteEventStore.java */
/* renamed from: b.i.a.b.j.t.i.l */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2503l implements C2511t.b {

    /* renamed from: a */
    public static final C2503l f5431a = new C2503l();

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        Encoding2 encoding2 = C2511t.f5441j;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            byte[] bArr2 = (byte[]) arrayList.get(i);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }
}
