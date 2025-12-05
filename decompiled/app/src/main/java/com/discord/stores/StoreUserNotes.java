package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelUserNote;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreUserNotes.kt */
/* loaded from: classes2.dex */
public final class StoreUserNotes extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, UserNoteState> notesByUserId;
    private Map<Long, ? extends UserNoteState> notesByUserIdSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreUserNotes.kt */
    public static abstract class UserNoteState {

        /* compiled from: StoreUserNotes.kt */
        public static final class Empty extends UserNoteState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: StoreUserNotes.kt */
        public static final /* data */ class Loaded extends UserNoteState {
            private final ModelUserNote note;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelUserNote modelUserNote) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelUserNote, "note");
                this.note = modelUserNote;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelUserNote modelUserNote, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelUserNote = loaded.note;
                }
                return loaded.copy(modelUserNote);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelUserNote getNote() {
                return this.note;
            }

            public final Loaded copy(ModelUserNote note) {
                Intrinsics3.checkNotNullParameter(note, "note");
                return new Loaded(note);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.note, ((Loaded) other).note);
                }
                return true;
            }

            public final ModelUserNote getNote() {
                return this.note;
            }

            public int hashCode() {
                ModelUserNote modelUserNote = this.note;
                if (modelUserNote != null) {
                    return modelUserNote.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(note=");
                sbM833U.append(this.note);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: StoreUserNotes.kt */
        public static final class Loading extends UserNoteState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private UserNoteState() {
        }

        public /* synthetic */ UserNoteState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserNotes.kt */
    /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1 */
    public static final class C65801 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $userId;

        /* compiled from: StoreUserNotes.kt */
        /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserNote, Unit> {

            /* compiled from: StoreUserNotes.kt */
            /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132651 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelUserNote $note;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132651(ModelUserNote modelUserNote) {
                    super(0);
                    this.$note = modelUserNote;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreUserNotes.access$handleRequestUserNoteSuccess(StoreUserNotes.this, this.$note);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserNote modelUserNote) {
                invoke2(modelUserNote);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserNote modelUserNote) {
                Intrinsics3.checkNotNullParameter(modelUserNote, "note");
                StoreUserNotes.access$getDispatcher$p(StoreUserNotes.this).schedule(new C132651(modelUserNote));
            }
        }

        /* compiled from: StoreUserNotes.kt */
        /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreUserNotes.kt */
            /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$2$1, reason: invalid class name */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C65801 c65801 = C65801.this;
                    StoreUserNotes.access$handleRequestUserNoteError(StoreUserNotes.this, c65801.$userId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreUserNotes.access$getDispatcher$p(StoreUserNotes.this).schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65801(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreUserNotes.access$getNotesByUserId$p(StoreUserNotes.this).containsKey(Long.valueOf(this.$userId))) {
                return;
            }
            StoreUserNotes.access$getNotesByUserId$p(StoreUserNotes.this).put(Long.valueOf(this.$userId), UserNoteState.Loading.INSTANCE);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreUserNotes.access$getRestAPI$p(StoreUserNotes.this).getUserNote(this.$userId), false, 1, null), StoreUserNotes.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    /* compiled from: StoreUserNotes.kt */
    /* renamed from: com.discord.stores.StoreUserNotes$observeUserNote$1 */
    public static final class C65811 extends Lambda implements Function0<UserNoteState> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65811(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserNoteState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserNoteState invoke() {
            UserNoteState userNoteState = StoreUserNotes.this.getNotesByUserId().get(Long.valueOf(this.$userId));
            return userNoteState != null ? userNoteState : UserNoteState.Loading.INSTANCE;
        }
    }

    /* compiled from: StoreUserNotes.kt */
    /* renamed from: com.discord.stores.StoreUserNotes$saveNote$1 */
    public static final class C65821 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $note;
        public final /* synthetic */ long $userId;

        /* compiled from: StoreUserNotes.kt */
        /* renamed from: com.discord.stores.StoreUserNotes$saveNote$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C65821 c65821 = C65821.this;
                StoreUserNotes.access$updateNoteInternal(StoreUserNotes.this, c65821.$userId, c65821.$note);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65821(long j, String str) {
            super(1);
            this.$userId = j;
            this.$note = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreUserNotes.access$getDispatcher$p(StoreUserNotes.this).schedule(new AnonymousClass1());
        }
    }

    public /* synthetic */ StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.dispatcher;
    }

    public static final /* synthetic */ Map access$getNotesByUserId$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.notesByUserId;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.restAPI;
    }

    public static final /* synthetic */ void access$handleRequestUserNoteError(StoreUserNotes storeUserNotes, long j) {
        storeUserNotes.handleRequestUserNoteError(j);
    }

    public static final /* synthetic */ void access$handleRequestUserNoteSuccess(StoreUserNotes storeUserNotes, ModelUserNote modelUserNote) {
        storeUserNotes.handleRequestUserNoteSuccess(modelUserNote);
    }

    public static final /* synthetic */ void access$updateNoteInternal(StoreUserNotes storeUserNotes, long j, String str) {
        storeUserNotes.updateNoteInternal(j, str);
    }

    @Store3
    private final void handleRequestUserNoteError(long userId) {
        this.notesByUserId.put(Long.valueOf(userId), UserNoteState.Empty.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleRequestUserNoteSuccess(ModelUserNote note) {
        long noteUserId = note.getNoteUserId();
        String note2 = note.getNote();
        if (note2 == null) {
            note2 = "";
        }
        updateNoteInternal(noteUserId, note2);
    }

    @Store3
    private final void updateNoteInternal(long userId, String note) {
        if (StringsJVM.isBlank(note)) {
            this.notesByUserId.put(Long.valueOf(userId), UserNoteState.Empty.INSTANCE);
        } else {
            this.notesByUserId.put(Long.valueOf(userId), new UserNoteState.Loaded(new ModelUserNote(userId, note)));
        }
        markChanged();
    }

    public final Map<Long, UserNoteState> getNotesByUserId() {
        return this.notesByUserIdSnapshot;
    }

    @Store3
    public final void handleConnectionOpen() {
        this.notesByUserId.clear();
        markChanged();
    }

    @Store3
    public final void handleNoteUpdate(ModelUserNote.Update update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        updateNoteInternal(update.getId(), update.getNote());
    }

    public final void loadNote(long userId) {
        this.dispatcher.schedule(new C65801(userId));
    }

    public final Observable<UserNoteState> observeUserNote(long userId) {
        Observable<UserNoteState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65811(userId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void saveNote(Context context, long userId, String note) {
        Intrinsics3.checkNotNullParameter(note, "note");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserNotes(userId, new RestAPIParams.UserNoteUpdate(note)), false, 1, null), StoreUserNotes.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C65821(userId, note), 60, (Object) null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.notesByUserIdSnapshot = new HashMap(this.notesByUserId);
    }

    public StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.notesByUserId = new HashMap();
        this.notesByUserIdSnapshot = Maps6.emptyMap();
    }
}
