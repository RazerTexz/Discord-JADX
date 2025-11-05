package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.streams.StreamContext;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.FuncN;

/* compiled from: StreamContextService.kt */
/* loaded from: classes2.dex */
public final class StreamContextService {
    private final StoreApplicationStreamPreviews applicationStreamPreviewStore;
    private final StoreApplicationStreaming applicationStreamingStore;
    private final StoreChannels channelStore;
    private final StoreGuilds guildStore;
    private final StorePermissions permissionsStore;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;
    private final StoreVoiceStates voiceStateStore;

    /* compiled from: StreamContextService.kt */
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForActiveStream$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<StoreApplicationStreaming.ActiveApplicationStream, Observable<? extends StreamContext>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends StreamContext> call(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
            return call2(activeApplicationStream);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StreamContext> call2(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
            if (activeApplicationStream == null) {
                return new k(null);
            }
            return StreamContextService.this.getForUser(activeApplicationStream.getStream().getOwnerId(), false);
        }
    }

    /* compiled from: StreamContextService.kt */
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForAllStreamingUsers$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends ModelApplicationStream>, Collection<? extends ModelApplicationStream>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Collection<? extends ModelApplicationStream> call(Map<Long, ? extends ModelApplicationStream> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Collection<ModelApplicationStream> call2(Map<Long, ? extends ModelApplicationStream> map) {
            return map.values();
        }
    }

    /* compiled from: StreamContextService.kt */
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForAllStreamingUsers$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Collection<? extends ModelApplicationStream>, Observable<? extends Map<Long, ? extends StreamContext>>> {

        /* compiled from: StreamContextService.kt */
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForAllStreamingUsers$2$1, reason: invalid class name */
        public static final class AnonymousClass1<R> implements FuncN<Map<Long, ? extends StreamContext>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // rx.functions.FuncN
            public /* bridge */ /* synthetic */ Map<Long, ? extends StreamContext> call(Object[] objArr) {
                return call2(objArr);
            }

            @Override // rx.functions.FuncN
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, ? extends StreamContext> call2(Object[] objArr) {
                m.checkNotNullExpressionValue(objArr, "allUserStreamContexts");
                ArrayList arrayList = new ArrayList();
                for (Object obj : objArr) {
                    if (!(obj instanceof StreamContext)) {
                        obj = null;
                    }
                    StreamContext streamContext = (StreamContext) obj;
                    if (streamContext != null) {
                        arrayList.add(streamContext);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList, 10)), 16));
                for (T t : arrayList) {
                    linkedHashMap.put(Long.valueOf(((StreamContext) t).getUser().getId()), t);
                }
                return linkedHashMap;
            }
        }

        public AnonymousClass2() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends StreamContext>> call(Collection<? extends ModelApplicationStream> collection) {
            return call2(collection);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, StreamContext>> call2(Collection<? extends ModelApplicationStream> collection) {
            if (collection.isEmpty()) {
                return new k(h0.emptyMap());
            }
            m.checkNotNullExpressionValue(collection, "allUserStreams");
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(StreamContextService.this.getForUser(((ModelApplicationStream) it.next()).getOwnerId(), false));
            }
            return Observable.b(arrayList, AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: StreamContextService.kt */
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<ModelApplicationStream, Observable<? extends StreamContext>> {
        public final /* synthetic */ boolean $includePreview;
        public final /* synthetic */ long $userId;

        /* compiled from: StreamContextService.kt */
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03451<T, R> implements b<Map<Long, ? extends GuildMember>, GuildMember> {
            public C03451() {
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
                return call2((Map<Long, GuildMember>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final GuildMember call2(Map<Long, GuildMember> map) {
                return map.get(Long.valueOf(AnonymousClass1.this.$userId));
            }
        }

        /* compiled from: StreamContextService.kt */
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements b<GuildMember, String> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ String call(GuildMember guildMember) {
                return call2(guildMember);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final String call2(GuildMember guildMember) {
                if (guildMember != null) {
                    return guildMember.getNick();
                }
                return null;
            }
        }

        /* compiled from: StreamContextService.kt */
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends d0.z.d.o implements Function10<Guild, StoreApplicationStreamPreviews.StreamPreview, Long, User, MeUser, String, Map<Long, ? extends VoiceState>, Channel, Long, StoreApplicationStreaming.ActiveApplicationStream, StreamContext> {
            public final /* synthetic */ ModelApplicationStream $stream;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(ModelApplicationStream modelApplicationStream) {
                super(10);
                this.$stream = modelApplicationStream;
            }

            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ StreamContext invoke(Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Long l, User user, MeUser meUser, String str, Map<Long, ? extends VoiceState> map, Channel channel, Long l2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                return invoke(guild, streamPreview, l, user, meUser, str, (Map<Long, VoiceState>) map, channel, l2.longValue(), activeApplicationStream);
            }

            public final StreamContext invoke(Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Long l, User user, MeUser meUser, String str, Map<Long, VoiceState> map, Channel channel, long j, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                m.checkNotNullParameter(meUser, "me");
                m.checkNotNullParameter(map, "voiceStates");
                if (((this.$stream instanceof ModelApplicationStream.GuildStream) && guild == null) || user == null) {
                    return null;
                }
                int userLimit = channel != null ? channel.getUserLimit() : 0;
                boolean z2 = userLimit > 0 && map.size() >= userLimit;
                return new StreamContext(this.$stream, guild, streamPreview, (!(this.$stream instanceof ModelApplicationStream.GuildStream) || PermissionUtils.can(Permission.CONNECT, l) || (channel != null && (channel.getId() > j ? 1 : (channel.getId() == j ? 0 : -1)) == 0)) ? (!z2 || PermissionUtils.can(16L, l)) ? StreamContext.Joinability.CAN_CONNECT : StreamContext.Joinability.VOICE_CHANNEL_FULL : StreamContext.Joinability.MISSING_PERMISSIONS, user, str, activeApplicationStream != null && activeApplicationStream.getState().isStreamActive() && m.areEqual(activeApplicationStream.getStream(), this.$stream), user.getId() == meUser.getId());
            }
        }

        public AnonymousClass1(boolean z2, long j) {
            this.$includePreview = z2;
            this.$userId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends StreamContext> call(ModelApplicationStream modelApplicationStream) {
            return call2(modelApplicationStream);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StreamContext> call2(ModelApplicationStream modelApplicationStream) {
            long guildId;
            if (modelApplicationStream == null) {
                return new k(null);
            }
            if (modelApplicationStream instanceof ModelApplicationStream.GuildStream) {
                guildId = ((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId();
            } else {
                if (!(modelApplicationStream instanceof ModelApplicationStream.CallStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                guildId = 0;
            }
            Observable<Guild> observableObserveGuild = StreamContextService.access$getGuildStore$p(StreamContextService.this).observeGuild(guildId);
            StreamContextService streamContextService = StreamContextService.this;
            Observable observableAccess$getPreviewObservable = StreamContextService.access$getPreviewObservable(streamContextService, modelApplicationStream, this.$includePreview, StreamContextService.access$getApplicationStreamPreviewStore$p(streamContextService));
            Observable<Long> observableObservePermissionsForChannel = StreamContextService.access$getPermissionsStore$p(StreamContextService.this).observePermissionsForChannel(modelApplicationStream.getChannelId());
            Observable<User> observableObserveUser = StreamContextService.access$getUserStore$p(StreamContextService.this).observeUser(this.$userId);
            Observable observableObserveMe$default = StoreUser.observeMe$default(StreamContextService.access$getUserStore$p(StreamContextService.this), false, 1, null);
            Observable<R> observableR = StreamContextService.access$getGuildStore$p(StreamContextService.this).observeComputed(guildId).G(new C03451()).G(AnonymousClass2.INSTANCE).r();
            m.checkNotNullExpressionValue(observableR, "guildStore\n             …  .distinctUntilChanged()");
            return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveGuild, observableAccess$getPreviewObservable, observableObservePermissionsForChannel, observableObserveUser, observableObserveMe$default, observableR, StreamContextService.access$getVoiceStateStore$p(StreamContextService.this).observe(guildId, modelApplicationStream.getChannelId()), StreamContextService.access$getChannelStore$p(StreamContextService.this).observeChannel(modelApplicationStream.getChannelId()), StreamContextService.access$getVoiceChannelSelectedStore$p(StreamContextService.this).observeSelectedVoiceChannelId(), StreamContextService.access$getApplicationStreamingStore$p(StreamContextService.this).observeActiveStream(), new AnonymousClass3(modelApplicationStream));
        }
    }

    public StreamContextService() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        m.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        m.checkNotNullParameter(storeGuilds, "guildStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeVoiceStates, "voiceStateStore");
        m.checkNotNullParameter(storeChannels, "channelStore");
        m.checkNotNullParameter(storeApplicationStreamPreviews, "applicationStreamPreviewStore");
        this.applicationStreamingStore = storeApplicationStreaming;
        this.guildStore = storeGuilds;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.voiceStateStore = storeVoiceStates;
        this.channelStore = storeChannels;
        this.applicationStreamPreviewStore = storeApplicationStreamPreviews;
    }

    public static final /* synthetic */ StoreApplicationStreamPreviews access$getApplicationStreamPreviewStore$p(StreamContextService streamContextService) {
        return streamContextService.applicationStreamPreviewStore;
    }

    public static final /* synthetic */ StoreApplicationStreaming access$getApplicationStreamingStore$p(StreamContextService streamContextService) {
        return streamContextService.applicationStreamingStore;
    }

    public static final /* synthetic */ StoreChannels access$getChannelStore$p(StreamContextService streamContextService) {
        return streamContextService.channelStore;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildStore$p(StreamContextService streamContextService) {
        return streamContextService.guildStore;
    }

    public static final /* synthetic */ StorePermissions access$getPermissionsStore$p(StreamContextService streamContextService) {
        return streamContextService.permissionsStore;
    }

    public static final /* synthetic */ Observable access$getPreviewObservable(StreamContextService streamContextService, ModelApplicationStream modelApplicationStream, boolean z2, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return streamContextService.getPreviewObservable(modelApplicationStream, z2, storeApplicationStreamPreviews);
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StreamContextService streamContextService) {
        return streamContextService.userStore;
    }

    public static final /* synthetic */ StoreVoiceChannelSelected access$getVoiceChannelSelectedStore$p(StreamContextService streamContextService) {
        return streamContextService.voiceChannelSelectedStore;
    }

    public static final /* synthetic */ StoreVoiceStates access$getVoiceStateStore$p(StreamContextService streamContextService) {
        return streamContextService.voiceStateStore;
    }

    private final Observable<? extends StoreApplicationStreamPreviews.StreamPreview> getPreviewObservable(ModelApplicationStream stream, boolean includePreview, StoreApplicationStreamPreviews applicationStreamPreviewStore) {
        if (includePreview) {
            return applicationStreamPreviewStore.observeStreamPreview(stream);
        }
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
        return kVar;
    }

    public final Observable<StreamContext> getForActiveStream() {
        Observable observableY = this.applicationStreamingStore.observeActiveStream().Y(new AnonymousClass1());
        m.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  )\n          }\n        }");
        return observableY;
    }

    public final Observable<Map<Long, StreamContext>> getForAllStreamingUsers() {
        Observable<Map<Long, StreamContext>> observableY = this.applicationStreamingStore.observeStreamsByUser().G(AnonymousClass1.INSTANCE).Y(new AnonymousClass2());
        m.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public final Observable<StreamContext> getForUser(long userId, boolean includePreview) {
        Observable observableY = this.applicationStreamingStore.observeStreamsForUser(userId).Y(new AnonymousClass1(includePreview, userId));
        m.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public /* synthetic */ StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews);
    }
}
