package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.UserMentionableSource;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Lazy;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: InputAutocompletables.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables {
    public static final InputAutocompletables INSTANCE = new InputAutocompletables();

    /* renamed from: EMOJI_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy EMOJI_SOURCE = LazyJVM.lazy(InputAutocompletables4.INSTANCE);

    /* renamed from: CHANNEL_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy CHANNEL_SOURCE = LazyJVM.lazy(InputAutocompletables3.INSTANCE);

    /* renamed from: USERS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy USERS_SOURCE = LazyJVM.lazy(InputAutocompletables5.INSTANCE);

    /* renamed from: APPLICATION_COMMANDS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy APPLICATION_COMMANDS_SOURCE = LazyJVM.lazy(InputAutocompletables2.INSTANCE);

    /* compiled from: InputAutocompletables.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$observeChannelAutocompletables$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: InputAutocompletables.kt */
        /* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$observeChannelAutocompletables$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02541<T1, T2, T3, T4, R> implements Func4<Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> {
            public static final C02541 INSTANCE = new C02541();

            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> call(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
                return call2(map, map2, map3, map4);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<LeadingIdentifier, Set<Autocompletable>> call2(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics3.checkNotNullExpressionValue(map, "commands");
                InputAutocompletables6.access$merge(linkedHashMap, map);
                Intrinsics3.checkNotNullExpressionValue(map2, "emojis");
                InputAutocompletables6.access$merge(linkedHashMap, map2);
                Intrinsics3.checkNotNullExpressionValue(map3, "channels");
                InputAutocompletables6.access$merge(linkedHashMap, map3);
                Intrinsics3.checkNotNullExpressionValue(map4, "users");
                InputAutocompletables6.access$merge(linkedHashMap, map4);
                return linkedHashMap;
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<LeadingIdentifier, Set<Autocompletable>>> call2(Channel channel) {
            InputAutocompletables inputAutocompletables = InputAutocompletables.INSTANCE;
            ApplicationCommandsAutocompletableSource application_commands_source = inputAutocompletables.getAPPLICATION_COMMANDS_SOURCE();
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            return Observable.h(application_commands_source.observeApplicationCommandAutocompletables(channel), inputAutocompletables.getEMOJI_SOURCE().observeEmojiAutocompletables(channel), inputAutocompletables.getCHANNEL_SOURCE().observeChannelAutocompletables(channel.getGuildId()), inputAutocompletables.getUSERS_SOURCE().observeUserAutocompletables(channel), C02541.INSTANCE);
        }
    }

    private InputAutocompletables() {
    }

    public final ApplicationCommandsAutocompletableSource getAPPLICATION_COMMANDS_SOURCE() {
        return (ApplicationCommandsAutocompletableSource) APPLICATION_COMMANDS_SOURCE.getValue();
    }

    public final ChannelAutocompletableSource getCHANNEL_SOURCE() {
        return (ChannelAutocompletableSource) CHANNEL_SOURCE.getValue();
    }

    public final EmojiAutocompletableSource getEMOJI_SOURCE() {
        return (EmojiAutocompletableSource) EMOJI_SOURCE.getValue();
    }

    public final UserMentionableSource getUSERS_SOURCE() {
        return (UserMentionableSource) USERS_SOURCE.getValue();
    }

    public final Observable<Map<LeadingIdentifier, Set<Autocompletable>>> observeChannelAutocompletables(long channelId) {
        Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY = observableG.Y(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…e>>\n          }\n        }");
        return ObservableExtensionsKt.computationLatest(observableY);
    }
}
