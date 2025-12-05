package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;

/* compiled from: lambda */
/* renamed from: b.a.m.a.b */
/* loaded from: classes.dex */
public final /* synthetic */ class C1132b implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1512a;

    public /* synthetic */ C1132b(Model.JsonReader jsonReader) {
        this.f1512a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelAuditLogEntry) this.f1512a.parse(new ModelAuditLogEntry());
    }
}
