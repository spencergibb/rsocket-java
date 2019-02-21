package io.rsocket.frame;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import reactor.util.annotation.Nullable;

/** FragmentationFlyweight is used to re-assemble frames */
public class FragmentationFlyweight {
  public static ByteBuf encode(final ByteBufAllocator allocator, ByteBuf header, ByteBuf data) {
    return encode(allocator, header, null, data);
  }

  public static ByteBuf encode(
      final ByteBufAllocator allocator, ByteBuf header, @Nullable ByteBuf metadata, ByteBuf data) {
    if (metadata == null) {
      return DataAndMetadataFlyweight.encodeOnlyData(allocator, header, data);
    }  else {
      return DataAndMetadataFlyweight.encode(allocator, header, metadata, data);
    }
  }
}
