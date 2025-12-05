package p007b.p008a.p033m.p034a;

import com.discord.api.guild.Guild;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.l */
/* loaded from: classes.dex */
public final /* synthetic */ class C1151l implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1531a;

    public /* synthetic */ C1151l(Model.JsonReader jsonReader) {
        this.f1531a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Guild) InboundGatewayGsonParser.fromJson(this.f1531a, Guild.class);
    }
}
