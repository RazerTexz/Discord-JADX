package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildIntegration;

/* JADX INFO: renamed from: b.a.m.a.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1136d implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1516a;

    public /* synthetic */ C1136d(Model.JsonReader jsonReader) {
        this.f1516a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelGuildIntegration) this.f1516a.parse(new ModelGuildIntegration());
    }
}
