package p007b.p008a.p033m.p034a;

import com.discord.api.channel.Channel;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.b0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1133b0 implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1513a;

    public /* synthetic */ C1133b0(Model.JsonReader jsonReader) {
        this.f1513a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Channel) InboundGatewayGsonParser.fromJson(this.f1513a, Channel.class);
    }
}
