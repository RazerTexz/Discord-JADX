package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelWebhook;

/* compiled from: lambda */
/* renamed from: b.a.m.a.e */
/* loaded from: classes.dex */
public final /* synthetic */ class C1138e implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1518a;

    public /* synthetic */ C1138e(Model.JsonReader jsonReader) {
        this.f1518a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelWebhook) this.f1518a.parse(new ModelWebhook());
    }
}
