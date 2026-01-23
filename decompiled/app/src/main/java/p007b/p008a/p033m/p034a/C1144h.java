package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: renamed from: b.a.m.a.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1144h implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1524a;

    public /* synthetic */ C1144h(Model.JsonReader jsonReader) {
        this.f1524a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelAuditLogEntry.Change) this.f1524a.parse(new ModelAuditLogEntry.Change());
    }
}
