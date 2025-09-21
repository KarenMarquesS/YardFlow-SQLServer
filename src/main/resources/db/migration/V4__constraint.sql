-- FK moto -> IoT
ALTER TABLE tb_yf_moto
    ADD CONSTRAINT fk_moto_yardflow FOREIGN KEY (id_yf) REFERENCES tb_yf_IoT(id_yf);

-- FK IoT -> moto
ALTER TABLE tb_yf_IoT
    ADD CONSTRAINT fk_iot_moto FOREIGN KEY (moto_id) REFERENCES tb_yf_moto(id_moto);
