package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.s */
/* loaded from: classes.dex */
public final /* synthetic */ class C1158s implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
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
