package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelWebhook;

/* JADX INFO: renamed from: b.a.m.a.e */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1138e implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1518a;

    public /* synthetic */ C1138e(Model.JsonReader jsonReader) {
        this.f1518a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelWebhook) this.f1518a.parse(new ModelWebhook());
    }
}
