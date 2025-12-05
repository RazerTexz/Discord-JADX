package p007b.p008a.p060x.p061a;

import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.x.a.a */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1317a implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f2004a;

    public /* synthetic */ C1317a(Model.JsonReader jsonReader) {
        this.f2004a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.f2004a.nextString(null);
    }
}
