package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelPayload;

/* JADX INFO: renamed from: b.a.m.a.t */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1159t implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ModelPayload.VersionedModel f1539a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Model.JsonReader f1540b;

    public /* synthetic */ C1159t(ModelPayload.VersionedModel versionedModel, Model.JsonReader jsonReader) {
        this.f1539a = versionedModel;
        this.f1540b = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.f1539a.parseEntry(this.f1540b);
    }
}
