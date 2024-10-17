﻿using System;
using System.Collections.Generic;

namespace JuggleHiveWebapp.Server.Models;

public partial class Race
{
    public long Id { get; set; }

    public string Name { get; set; } = null!;

    public string Description { get; set; } = null!;

    public long StatId { get; set; }

    public int LevelUpHp { get; set; }

    public virtual ICollection<Chara> Charas { get; set; } = new List<Chara>();

    public virtual ICollection<RaceSkill> RaceSkills { get; set; } = new List<RaceSkill>();

    public virtual BaseStat Stat { get; set; } = null!;

    public virtual ICollection<Region> Regions { get; set; } = new List<Region>();
}
