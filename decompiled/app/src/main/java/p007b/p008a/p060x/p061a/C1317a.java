package p007b.p008a.p060x.p061a;

import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.x.a.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1317a implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f2004a;

    public /* synthetic */ C1317a(Model.JsonReader jsonReader) {
        this.f2004a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.f2004a.nextString(null);
    }
}
