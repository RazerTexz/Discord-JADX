package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.Cursor;
import android.util.Base64;
import java.util.ArrayList;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p231j.AutoValue_TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t;
import p007b.p225i.p226a.p228b.p231j.p241w.PriorityMapping;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.p */
/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2507p implements C2511t.b {

    /* JADX INFO: renamed from: a */
    public static final C2507p f5435a = new C2507p();

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        Encoding2 encoding2 = C2511t.f5441j;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            TransportContext.a aVarM2358a = TransportContext.m2358a();
            aVarM2358a.mo2352b(cursor.getString(1));
            aVarM2358a.mo2353c(PriorityMapping.m2415b(cursor.getInt(2)));
            String string = cursor.getString(3);
            AutoValue_TransportContext.b bVar = (AutoValue_TransportContext.b) aVarM2358a;
            bVar.f5262b = string == null ? null : Base64.decode(string, 0);
            arrayList.add(bVar.mo2351a());
        }
        return arrayList;
    }
}
