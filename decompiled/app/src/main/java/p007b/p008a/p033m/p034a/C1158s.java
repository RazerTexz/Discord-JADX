package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.s */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1158s implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1538a;

    public /* synthetic */ C1158s(Model.JsonReader jsonReader) {
        this.f1538a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.f1538a;
        return jsonReader.nextList(new C1160u(jsonReader));
    }
}
