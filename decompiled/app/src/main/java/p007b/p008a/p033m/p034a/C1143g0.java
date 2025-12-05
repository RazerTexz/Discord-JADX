package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.g0 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1143g0 implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1523a;

    public /* synthetic */ C1143g0(Model.JsonReader jsonReader) {
        this.f1523a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.f1523a.nextStringOrNull();
    }
}
