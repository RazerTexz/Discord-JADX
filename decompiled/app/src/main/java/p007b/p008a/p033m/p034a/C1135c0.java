package p007b.p008a.p033m.p034a;

import com.discord.api.activity.Activity;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.c0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1135c0 implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1515a;

    public /* synthetic */ C1135c0(Model.JsonReader jsonReader) {
        this.f1515a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Activity) InboundGatewayGsonParser.fromJson(this.f1515a, Activity.class);
    }
}
