package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelSession;

/* JADX INFO: renamed from: b.a.m.a.m */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1152m implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1532a;

    public /* synthetic */ C1152m(Model.JsonReader jsonReader) {
        this.f1532a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelSession) this.f1532a.parse(new ModelSession());
    }
}
