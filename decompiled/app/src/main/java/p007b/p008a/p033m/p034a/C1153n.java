package p007b.p008a.p033m.p034a;

import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.n */
/* loaded from: classes.dex */
public final /* synthetic */ class C1153n implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1533a;

    public /* synthetic */ C1153n(Model.JsonReader jsonReader) {
        this.f1533a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ConnectedAccount) InboundGatewayGsonParser.fromJson(this.f1533a, ConnectedAccount.class);
    }
}
