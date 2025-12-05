package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.r */
/* loaded from: classes.dex */
public final /* synthetic */ class C1157r implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
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
