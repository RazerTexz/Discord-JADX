package p007b.p008a.p033m.p034a;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1134c implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1514a;

    public /* synthetic */ C1134c(Model.JsonReader jsonReader) {
        this.f1514a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (GuildScheduledEvent) InboundGatewayGsonParser.fromJson(this.f1514a, GuildScheduledEvent.class);
    }
}
