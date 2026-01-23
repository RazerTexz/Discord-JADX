package p007b.p008a.p033m.p034a;

import com.discord.api.channel.Channel;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.f */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1140f implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1520a;

    public /* synthetic */ C1140f(Model.JsonReader jsonReader) {
        this.f1520a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Channel) InboundGatewayGsonParser.fromJson(this.f1520a, Channel.class);
    }
}
