package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.g0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1143g0 implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1523a;

    public /* synthetic */ C1143g0(Model.JsonReader jsonReader) {
        this.f1523a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.f1523a.nextStringOrNull();
    }
}
