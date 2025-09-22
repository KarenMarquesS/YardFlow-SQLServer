-- FK IoT -> moto (1:1)
ALTER TABLE tb_yf_IoT
    ADD CONSTRAINT fk_iot_moto
        FOREIGN KEY (moto_id) REFERENCES tb_yf_moto(id_moto);
