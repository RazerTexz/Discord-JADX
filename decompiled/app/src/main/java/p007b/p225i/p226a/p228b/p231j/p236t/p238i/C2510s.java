package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t;
import p007b.p225i.p226a.p228b.p231j.p241w.PriorityMapping;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.s */
/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2510s implements C2511t.b {

    /* JADX INFO: renamed from: a */
    public final C2511t f5438a;

    /* JADX INFO: renamed from: b */
    public final TransportContext f5439b;

    /* JADX INFO: renamed from: c */
    public final EventInternal f5440c;

    public C2510s(C2511t c2511t, TransportContext transportContext, EventInternal eventInternal) {
        this.f5438a = c2511t;
        this.f5439b = transportContext;
        this.f5440c = eventInternal;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
    public Object apply(Object obj) {
        long jInsert;
        C2511t c2511t = this.f5438a;
        TransportContext transportContext = this.f5439b;
        EventInternal eventInternal = this.f5440c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding2 encoding2 = C2511t.f5441j;
        if (c2511t.m2407b().compileStatement("PRAGMA page_size").simpleQueryForLong() * c2511t.m2407b().compileStatement("PRAGMA page_count").simpleQueryForLong() >= c2511t.f5445n.mo2390e()) {
            return -1L;
        }
        Long lM2408c = c2511t.m2408c(sQLiteDatabase, transportContext);
        if (lM2408c != null) {
            jInsert = lM2408c.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", transportContext.mo2348b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.m2414a(transportContext.mo2350d())));
            contentValues.put("next_request_ms", (Integer) 0);
            if (transportContext.mo2349c() != null) {
                contentValues.put(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(transportContext.mo2349c(), 0));
            }
            jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        int iMo2389d = c2511t.f5445n.mo2389d();
        byte[] bArr = eventInternal.mo2338d().f5277b;
        boolean z2 = bArr.length <= iMo2389d;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(jInsert));
        contentValues2.put("transport_name", eventInternal.mo2340g());
        contentValues2.put("timestamp_ms", Long.valueOf(eventInternal.mo2339e()));
        contentValues2.put("uptime_ms", Long.valueOf(eventInternal.mo2341h()));
        contentValues2.put("payload_encoding", eventInternal.mo2338d().f5276a.f5118a);
        contentValues2.put(ModelAuditLogEntry.CHANGE_KEY_CODE, eventInternal.mo2337c());
        contentValues2.put("num_attempts", (Integer) 0);
        contentValues2.put("inline", Boolean.valueOf(z2));
        contentValues2.put("payload", z2 ? bArr : new byte[0]);
        long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
        if (!z2) {
            int iCeil = (int) Math.ceil(((double) bArr.length) / ((double) iMo2389d));
            for (int i = 1; i <= iCeil; i++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (i - 1) * iMo2389d, Math.min(i * iMo2389d, bArr.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(jInsert2));
                contentValues3.put("sequence_num", Integer.valueOf(i));
                contentValues3.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues3);
            }
        }
        for (Map.Entry entry : Collections.unmodifiableMap(eventInternal.mo2336b()).entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(jInsert2));
            contentValues4.put(ModelAuditLogEntry.CHANGE_KEY_NAME, (String) entry.getKey());
            contentValues4.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues4);
        }
        return Long.valueOf(jInsert2);
    }
}
