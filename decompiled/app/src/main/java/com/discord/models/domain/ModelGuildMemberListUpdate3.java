package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildmember.GuildMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelGuildMemberListUpdate.kt */
/* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelGuildMemberListUpdate3<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $group;
    public final /* synthetic */ Ref$ObjectRef $member;
    public final /* synthetic */ Model.JsonReader $reader;

    public ModelGuildMemberListUpdate3(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$group = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$member = ref$ObjectRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1077769574) {
                if (iHashCode == 98629247 && str.equals("group")) {
                    this.$group.element = (T) ModelGuildMemberListUpdate.Group.Parser.INSTANCE.parse(this.$reader);
                    return;
                }
            } else if (str.equals("member")) {
                this.$member.element = (T) ((GuildMember) InboundGatewayGsonParser.fromJson(this.$reader, GuildMember.class));
                return;
            }
        }
        this.$reader.skipValue();
    }
}
