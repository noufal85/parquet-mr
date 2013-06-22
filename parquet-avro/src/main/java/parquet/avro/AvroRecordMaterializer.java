/**
 * Copyright 2012 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package parquet.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.IndexedRecord;
import parquet.io.api.GroupConverter;
import parquet.io.api.RecordMaterializer;
import parquet.schema.MessageType;

class AvroRecordMaterializer extends RecordMaterializer<IndexedRecord> {

  private AvroIndexedRecordConverter root;

  public AvroRecordMaterializer(MessageType requestedSchema, Schema avroSchema) {
    this.root = new AvroIndexedRecordConverter(requestedSchema, avroSchema);
  }

  @Override
  public IndexedRecord getCurrentRecord() {
    return root.getCurrentRecord();
  }

  @Override
  public GroupConverter getRootConverter() {
    return root;
  }
}
