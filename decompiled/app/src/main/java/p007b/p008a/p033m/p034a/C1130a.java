package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.a */
/* loaded from: classes.dex */
public final /* synthetic */ class C1130a implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1510a;

    public /* synthetic */ C1130a(Model.JsonReader jsonReader) {
        this.f1510a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.f1510a.nextLongOrNull();
    }
}
