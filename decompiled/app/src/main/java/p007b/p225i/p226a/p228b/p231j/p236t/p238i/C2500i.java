package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t;
import p007b.p225i.p226a.p228b.p231j.p241w.PriorityMapping;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.i */
/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2500i implements C2511t.b {

    /* JADX INFO: renamed from: a */
    public final long f5424a;

    /* JADX INFO: renamed from: b */
    public final TransportContext f5425b;

    public C2500i(long j, TransportContext transportContext) {
        this.f5424a = j;
        this.f5425b = transportContext;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
    public Object apply(Object obj) {
        long j = this.f5424a;
        TransportContext transportContext = this.f5425b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding2 encoding2 = C2511t.f5441j;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.mo2348b(), String.valueOf(PriorityMapping.m2414a(transportContext.mo2350d()))}) < 1) {
            contentValues.put("backend_name", transportContext.mo2348b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.m2414a(transportContext.mo2350d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
