package p007b.p008a.p033m.p034a;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.c */
/* loaded from: classes.dex */
public final /* synthetic */ class C1134c implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1514a;

    public /* synthetic */ C1134c(Model.JsonReader jsonReader) {
        this.f1514a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (GuildScheduledEvent) InboundGatewayGsonParser.fromJson(this.f1514a, GuildScheduledEvent.class);
    }
}
