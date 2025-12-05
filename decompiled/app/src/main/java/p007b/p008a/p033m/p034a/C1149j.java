package p007b.p008a.p033m.p034a;

import com.discord.api.voice.state.VoiceState;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelCall;

/* compiled from: lambda */
/* renamed from: b.a.m.a.j */
/* loaded from: classes.dex */
public final /* synthetic */ class C1149j implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1529a;

    public /* synthetic */ C1149j(Model.JsonReader jsonReader) {
        this.f1529a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.f1529a;
        int i = ModelCall.f18564j;
        return (VoiceState) InboundGatewayGsonParser.fromJson(jsonReader, VoiceState.class);
    }
}
