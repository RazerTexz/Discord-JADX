package com.discord.models.thread.dto;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: ModelThreadListSync.kt */
/* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelThreadListSync2<T> implements Action1<String> {
    public final /* synthetic */ Ref$LongRef $guildId;
    public final /* synthetic */ Ref$ObjectRef $members;
    public final /* synthetic */ Ref$ObjectRef $mostRecentMessages;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $threads;

    /* compiled from: ModelThreadListSync.kt */
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$1 */
    public static final class C55611<T> implements Model.JsonReader.ItemFactory<Channel> {
        public C55611() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Channel get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Channel get() {
            return (Channel) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, Channel.class);
        }
    }

    /* compiled from: ModelThreadListSync.kt */
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$2 */
    public static final class C55622<T> implements Model.JsonReader.ItemFactory<ThreadMember> {
        public C55622() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ThreadMember get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ThreadMember get() {
            return (ThreadMember) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, ThreadMember.class);
        }
    }

    /* compiled from: ModelThreadListSync.kt */
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$3 */
    public static final class C55633<T> implements Action1<String> {
        public C55633() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            ThreadMember threadMember = (ThreadMember) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, ThreadMember.class);
            Intrinsics3.checkNotNullExpressionValue(str, "threadId");
            ((List) ModelThreadListSync2.this.$members.element).add(new ThreadMember(Long.parseLong(str), threadMember.getUserId(), threadMember.getFlags(), threadMember.getJoinTimestamp(), threadMember.getMuted(), threadMember.getMuteConfig()));
        }
    }

    /* compiled from: ModelThreadListSync.kt */
    /* renamed from: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1$4 */
    public static final class C55644<T> implements Model.JsonReader.ItemFactory<Message> {
        public C55644() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Message get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Message get() {
            return (Message) InboundGatewayGsonParser.fromJson(ModelThreadListSync2.this.$reader, Message.class);
        }
    }

    public ModelThreadListSync2(Ref$LongRef ref$LongRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.$guildId = ref$LongRef;
        this.$reader = jsonReader;
        this.$threads = ref$ObjectRef;
        this.$members = ref$ObjectRef2;
        this.$mostRecentMessages = ref$ObjectRef3;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -1337936983:
                    if (str.equals("threads")) {
                        this.$threads.element = (T) this.$reader.nextList(new C55611());
                        return;
                    }
                    break;
                case -1306538777:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                        Ref$LongRef ref$LongRef = this.$guildId;
                        Long lNextLongOrNull = this.$reader.nextLongOrNull();
                        Intrinsics3.checkNotNull(lNextLongOrNull);
                        ref$LongRef.element = lNextLongOrNull.longValue();
                        return;
                    }
                    break;
                case 948881689:
                    if (str.equals("members")) {
                        if (this.$reader.peek() != JsonToken.BEGIN_ARRAY) {
                            this.$reader.nextObject(new C55633());
                            return;
                        }
                        Ref$ObjectRef ref$ObjectRef = this.$members;
                        T t = (T) this.$reader.nextList(new C55622());
                        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { Inboun…readMember::class.java) }");
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case 1472794100:
                    if (str.equals("most_recent_messages")) {
                        this.$mostRecentMessages.element = (T) this.$reader.nextList(new C55644());
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
