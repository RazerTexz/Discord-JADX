package p007b.p008a.p033m.p034a;

import com.discord.api.channel.Channel;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.f */
/* loaded from: classes.dex */
public final /* synthetic */ class C1140f implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1520a;

    public /* synthetic */ C1140f(Model.JsonReader jsonReader) {
        this.f1520a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Channel) InboundGatewayGsonParser.fromJson(this.f1520a, Channel.class);
    }
}
