package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.r */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1157r implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1537a;

    public /* synthetic */ C1157r(Model.JsonReader jsonReader) {
        this.f1537a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.f1537a;
        return jsonReader.nextList(new C1156q(jsonReader));
    }
}
