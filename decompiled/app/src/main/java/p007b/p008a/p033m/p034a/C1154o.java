package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.o */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1154o implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1534a;

    public /* synthetic */ C1154o(Model.JsonReader jsonReader) {
        this.f1534a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.f1534a.nextString(null);
    }
}
